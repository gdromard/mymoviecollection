package net.dromard.movies.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import net.dromard.common.io.StreamHelper;
import net.dromard.common.util.StringHelper;
import net.dromard.movies.MovieApplicationContext;
import net.dromard.movies.dao.DAOLocator;
import net.dromard.movies.dao.DAOLocatorAware;
import net.dromard.movies.model.Movie;

public class MovieCoverExtractorService extends DAOLocatorAware implements IMovieExtractorService {
	private static String SEARCH_URL = "http://www.moviecovers.com/multicrit.html?tri=Titre&slow=2&titre={0}";
	private static String GET_URL = "http://www.moviecovers.com/getzip.html/{0}.zip";
	private static Map<String, String> titleToUrl = new HashMap<String, String>();

	public List<String> findFromWWWByTitle(String title) throws MalformedURLException, IOException {
		return searchMovie(title);
	}

	public Movie getFromWWWByTitle(String title) throws MalformedURLException, IOException, ParseException {
		return extractMovie(getDaoLocator(), title, MovieApplicationContext.getImagePath());
	}

	
	public static List<String> searchMovie(String movieName) throws MalformedURLException, IOException {
		final String SEARCH_MOVIE_KEY = "<LI><A href=\"/film/titre_";
		String url = MessageFormat.format(SEARCH_URL, URLEncoder.encode(movieName, "UTF-8"));
		List<String> foundMovies = new ArrayList<String>();
	    BufferedReader htmlCode = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
	    String line;
	    
	    // Read all input lines
	    while ((line = htmlCode.readLine()) != null) {
	    	if (line.indexOf(SEARCH_MOVIE_KEY) > -1) {
	    		String titleUrl = line.substring(line.indexOf(SEARCH_MOVIE_KEY) + SEARCH_MOVIE_KEY.length(), line.indexOf(".html\">", SEARCH_MOVIE_KEY.length()));
	    		String title = line.substring(line.indexOf('>', SEARCH_MOVIE_KEY.length()) + 1).replaceAll("</[aA]>", "");
	    		titleToUrl.put(title, titleUrl);
	    		foundMovies.add(title);
	    	}
	    }
	    return foundMovies;
	}
	
	public static Movie extractMovie(DAOLocator daoLocator, String exactName, String coverStoringPath) throws MalformedURLException, IOException, ParseException {
		// Remove Year at end of movie Name
		/*
		if (exactName.substring(exactName.length()-7).matches(" \\([0-9]*\\)")) {
			exactName = exactName.substring(0, exactName.length()-7);
		}
		String url = MessageFormat.format(GET_URL, URLEncoder.encode(exactName, "UTF-8")).replaceAll(" ", "%20");
		*/
		
		String url = MessageFormat.format(GET_URL, titleToUrl.get(exactName));
		System.out.println("Trying to download: " + url);
		File zipTmp = downloadZip(new URL(url).openStream());
		System.out.println("Zip file successfully downloaded to " + zipTmp.getAbsolutePath());
		File movieCoverDumpFile = extractZipFile(zipTmp, coverStoringPath);
		return loadMovie(daoLocator, movieCoverDumpFile);
	}
	
    private static Movie loadMovie(DAOLocator daoLocator, File movieCoverDumpFile) throws UnsupportedEncodingException, MalformedURLException, IOException, ParseException {
	    BufferedReader filmReader = new BufferedReader(new InputStreamReader(movieCoverDumpFile.toURL().openStream(), "ISO-8859-1"));
	    String title = filmReader.readLine();
	    String[] directors = filmReader.readLine().split("/");
	    String year = filmReader.readLine();
	    String nationality = filmReader.readLine();
	    String genre = filmReader.readLine();
	    String length = filmReader.readLine(); // format is 2H00
	    String[] casting = filmReader.readLine().split(";");
	    String synopsis = filmReader.readLine();
	    String provider = filmReader.readLine();
	    String originalTitle = filmReader.readLine();
	    
	    Movie movie = new Movie();
	    movie.setTitle(title);
	    for (int i = 0; i < directors.length; i++) {
	    	String[] cast = extractLastnameFirstName(directors[i]);
	    	movie.setDirector(daoLocator.getCastingDAO().findOrCreate(cast[1], cast[0]));
		}
    	movie.setCasting(StringHelper.arrayToString(casting, ", "));
		movie.setNationality(daoLocator.getMovieNationalityDAO().findOrCreate(nationality));
	    movie.setGenre(daoLocator.getMovieGenreDAO().findOrCreate(genre));
	    movie.setYear(Integer.parseInt(year));
	    SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
	    movie.setLength(formater.parse(length.replace('H', ':')));
	    movie.setSynopsis(synopsis);
	    movie.setOriginalTitle(originalTitle);
		return movie;
	}
    
    private static String[] extractLastnameFirstName(String names) {
    	String[] aNames = names.split(" ");
    	if (names.length() > 2) {
    		String[] tmp = new String[] { aNames[0] + " ", "" };
    		for (int i = 1; i < aNames.length; i++) {
    			if (aNames[i].matches("[A-Z][a-z]")) {
    				tmp[0] += aNames[i] + " ";
    			} else {
    				tmp[1] += aNames[i] + " ";
    			}
			}
    		tmp[0] = tmp[0].trim();
    		tmp[1] = tmp[1].trim();
    		return tmp;
    	}
    	return aNames;
    }
    
	private static File extractZipFile(File zipFile, String imagePath) {
        
        try {
        	File image = null;
        	File film = null;
            // Create input and output streams
            ZipInputStream inStream = new ZipInputStream(new FileInputStream(zipFile));
            
            ZipEntry entry;
            byte[] buffer = new byte[1024];
            int nrBytesRead;
            
            // Get next zip entry and start reading data
            while ((entry = inStream.getNextEntry()) != null) {
            	if (entry.getName().endsWith(".film") || entry.getName().endsWith(".jpg")) {
            		OutputStream outStream = null;
            		if (entry.getName().endsWith(".film")) {
            			film = new File(entry.getName());
            			outStream = new FileOutputStream(image);
            		} else {
            			image  = new File(imagePath + "/" + entry.getName());
            			System.out.println("Image has been saved to : " + image.getAbsolutePath());
            			outStream = new FileOutputStream(image);
            		}
            		while ((nrBytesRead = inStream.read(buffer)) > 0) {
            			outStream.write(buffer, 0, nrBytesRead);
            		}
            		outStream.close();
            		
            	}
            }
                    
            // Finish off by closing the streams
            inStream.close();
            return film;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
	
	private static File downloadZip(InputStream stream) throws IOException {
		File tmpZip = File.createTempFile("tmp", "zip");
		StreamHelper.streamCopier(stream, new FileOutputStream(tmpZip));
		return tmpZip;
	}
}
