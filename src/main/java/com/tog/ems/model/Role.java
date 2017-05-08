package com.tog.ems.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="ROLES")
public class Role extends BaseRecord implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2164077795416768098L;

	@Id 
	@GeneratedValue
	@Column(name = "ROLE_ID")
	private Long id;
	
	@Column(name = "NAME", unique = true, nullable = false, length = 45)
	private String role;
	
	@Column(name = "DESCRIPTION", columnDefinition="TEXT")
	@Type(type="text")
	private String description;

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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}	
	 
}
