package com.tog.ems.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONS")
public class Person extends BaseRecord implements Serializable{
	
	/**
	 * Generated serialiazable version uid
	 */
	private static final long serialVersionUID = -4692731146459484175L;
	
	@Id 
	@GeneratedValue
	@Column(name = "PERS_ID")
	private Long id;

	@Column(name = "FIRST_NAME", unique = false, nullable = false, length = 45)
	private String firstName;
	
	@Column(name = "LAST_NAME", unique = false, nullable = false, length = 45)
	private String lastName;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROLE_ID")
	private Role role;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
    
}
