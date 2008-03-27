package net.dromard.movies.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import net.dromard.common.util.StringHelper;

import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

@Entity
@Conversion
public class Movie implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @Column(name = "ORIGINAL_TITLE")
    private String originalTitle;
    private Integer size;
    private Integer year;
    private Date length;
    private String synopsis;
    @Column(name = "IMAGE_LINK")
    private String imageLink;
    private String casting;
    @ManyToOne(cascade = CascadeType.ALL)
    private MovieFormat format;
    @ManyToOne(cascade = CascadeType.ALL)
    private MovieVersion version;
    @ManyToOne(cascade = CascadeType.ALL)
    private MovieQuality quality;
    @ManyToOne(cascade = CascadeType.ALL)
    private MovieGenre genre;
    @ManyToOne(cascade = CascadeType.ALL)
    private MovieNationality nationality;
    @ManyToOne(cascade = CascadeType.ALL)
    private Casting director;
    @ManyToOne(cascade = CascadeType.ALL)
    private Casting cast1;
    @ManyToOne(cascade = CascadeType.ALL)
    private Casting cast2;
    @ManyToOne(cascade = CascadeType.ALL)
    private Casting cast3;
    @ManyToOne(cascade = CascadeType.ALL)
    private Casting cast4;
    /*
    @OneToOne(cascade = CascadeType.ALL)
    private Contact rent;
     */

    /* Possible annotations:
    
    @OneToOne(cascade = CascadeType.ALL)
    -
    @ManyToMany
	@JoinTable(inverseJoinColumns = @JoinColumn(name = "ENTREE_ID"))
	-
     */
    
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the length
	 */
    @TypeConversion(converter = "net.dromard.movies.DateConverter")
	public Date getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
    @TypeConversion(converter = "net.dromard.movies.DateConverter")
	public void setLength(Date length) {
		this.length = length;
	}
	/**
	 * @return the originalTitle
	 */
	public String getOriginalTitle() {
		return originalTitle;
	}
	/**
	 * @param originalTitle the originalTitle to set
	 */
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the casting
	 */
	public String getCasting() {
		return casting;
	}
	/**
	 * @param casting the casting to set
	 */
	public void setCasting(String casting) {
		this.casting = casting;
	}
	/**
	 * @return the director
	 */
	public Casting getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(Casting director) {
		if (!StringHelper.isEmpty(director.getFirstname()) && StringHelper.isEmpty(director.getLastname())) {
			this.director = director;
		}
	}
	/**
	 * @return the imageLink
	 */
	public String getImageLink() {
		return imageLink;
	}
	/**
	 * @param imageLink the imageLink to set
	 */
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	/**
	 * @return the synopsis
	 */
	public String getSynopsis() {
		return synopsis;
	}
	/**
	 * @param synopsis the synopsis to set
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	/**
	 * @return the cast1
	 */
	public Casting getCast1() {
		return cast1;
	}
	/**
	 * @param cast the cast1 to set
	 */
	public void setCast1(Casting cast) {
		if (!StringHelper.isEmpty(cast.getFirstname()) && StringHelper.isEmpty(cast.getLastname())) {
			this.cast1 = cast;
		}
	}
	/**
	 * @return the cast2
	 */
	public Casting getCast2() {
		return cast2;
	}
	/**
	 * @param cast the cast2 to set
	 */
	public void setCast2(Casting cast) {
		if (!StringHelper.isEmpty(cast.getFirstname()) && StringHelper.isEmpty(cast.getLastname())) {
			this.cast2 = cast;
		}
	}
	/**
	 * @return the cast3
	 */
	public Casting getCast3() {
		return cast3;
	}
	/**
	 * @param cast the cast3 to set
	 */
	public void setCast3(Casting cast) {
		if (!StringHelper.isEmpty(cast.getFirstname()) && StringHelper.isEmpty(cast.getLastname())) {
			this.cast3 = cast;
		}
	}
	/**
	 * @return the cast4
	 */
	public Casting getCast4() {
		return cast4;
	}
	/**
	 * @param cast the cast4 to set
	 */
	public void setCast4(Casting cast) {
		if (!StringHelper.isEmpty(cast.getFirstname()) && StringHelper.isEmpty(cast.getLastname())) {
			this.cast4 = cast;
		}
	}
	/**
	 * @return the format
	 */
	public MovieFormat getFormat() {
		return format;
	}
	/**
	 * @param format the format to set
	 */
	public void setFormat(MovieFormat format) {
		if (!StringHelper.isEmpty(format.getName())) {
			this.format = format;
		}
	}
	/**
	 * @return the genre
	 */
	public MovieGenre getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(MovieGenre genre) {
		if (!StringHelper.isEmpty(genre.getName())) {
			this.genre = genre;
		}
	}
	/**
	 * @return the nationality
	 */
	public MovieNationality getNationality() {
		return nationality;
	}
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(MovieNationality nationality) {
		if (!StringHelper.isEmpty(nationality.getName())) {
			this.nationality = nationality;
		}
	}
	/**
	 * @return the quality
	 */
	public MovieQuality getQuality() {
		return quality;
	}
	/**
	 * @param quality the quality to set
	 */
	public void setQuality(MovieQuality quality) {
		if (!StringHelper.isEmpty(quality.getName())) {
			this.quality = quality;
		}
	}
	/**
	 * @return the version
	 */
	public MovieVersion getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(MovieVersion version) {
		if (!StringHelper.isEmpty(version.getName())) {
			this.version = version;
		}
	}
	/**
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append(id);
		s.append(", ");
		s.append(title);
		s.append(", ");
		s.append(originalTitle);
		s.append(", ");
	    s.append(format);
		s.append(", ");
	    s.append(version);
		s.append(", ");
	    s.append(quality);
		s.append(", ");
	    s.append(genre);
		s.append(", ");
	    s.append(year);
		s.append(", ");
		s.append(size);
		s.append(", ");
		s.append(length);
		s.append(", ");
	    s.append(synopsis);
		s.append(", ");
	    s.append(imageLink);
		s.append(", ");
	    s.append(director);
		s.append(", ");
	    s.append(casting);
	    s.append(", ");
	    s.append(nationality);
		s.append(", ");
	    s.append(cast1);
		s.append(", ");
	    s.append(cast2);
		s.append(", ");
	    s.append(cast3);
		s.append(", ");
	    s.append(cast4);
		/*
	    s.append(rent);
	    */
		return "[Movie: " + s.toString() + "]";
	}
}