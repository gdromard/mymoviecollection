package net.dromard.movies.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Genre")
public class MovieGenre implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    
	public MovieGenre() {
	}
	
	public MovieGenre(String name) {
		this();
		setName(name);
	}

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append(id);
		s.append(", ");
		s.append(name);
		return "[MovieGenre: " + id + ", " + name + "]";
	}
}