package com.tog.ems.service;

import java.util.Date;
import java.util.List;

import com.tog.ems.model.Person;
import com.tog.ems.model.Role;
import com.tog.ems.model.Status;

public interface PersonService {

	List<Person> getPeopleList();
	
	void addPerson(String firstName, String lastName, Role role,
			Date createdAt, String createdBy, Status status);
	
	void updatePerson(Long persId, String firstName, String lastName, Role role,
			Date updatedAt, String modifiedBy, Status status);
	
	boolean deletePerson(Long id);
}
