package net.dromard.movies.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Casting implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    
    public Casting() {
    }
    
    public Casting(String firstname, String lastname) {
    	this();
    	setFirstname(firstname);
    	setLastname(lastname);
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
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String name) {
		this.firstname = name;
	}
	
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append(id);
		s.append(", ");
		s.append(firstname);
		return "[MovieCasting: " + id + ", " + firstname + ", " + lastname + "]";
	}
}