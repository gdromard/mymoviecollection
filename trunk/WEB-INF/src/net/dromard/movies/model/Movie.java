package net.dromard.movies.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
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
    @ManyToOne(cascade = CascadeType.ALL)
    private Casting director;
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
	public Date getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
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
		this.director = director;
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
	 * @param cast1 the cast1 to set
	 */
	public void setCast1(Casting cast1) {
		this.cast1 = cast1;
	}
	/**
	 * @return the cast2
	 */
	public Casting getCast2() {
		return cast2;
	}
	/**
	 * @param cast2 the cast2 to set
	 */
	public void setCast2(Casting cast2) {
		this.cast2 = cast2;
	}
	/**
	 * @return the cast3
	 */
	public Casting getCast3() {
		return cast3;
	}
	/**
	 * @param cast3 the cast3 to set
	 */
	public void setCast3(Casting cast3) {
		this.cast3 = cast3;
	}
	/**
	 * @return the cast4
	 */
	public Casting getCast4() {
		return cast4;
	}
	/**
	 * @param cast4 the cast4 to set
	 */
	public void setCast4(Casting cast4) {
		this.cast4 = cast4;
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
		this.format = format;
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
		this.genre = genre;
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
		this.nationality = nationality;
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
		this.quality = quality;
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
		this.version = version;
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