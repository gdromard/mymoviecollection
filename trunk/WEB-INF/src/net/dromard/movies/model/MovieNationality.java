package net.dromard.movies.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Nationality")
public class MovieNationality implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    
	public MovieNationality() {
	}
    
	public MovieNationality(String name) {
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
		return "[MovieNationality: " + id + ", " + name + "]";
	}
}