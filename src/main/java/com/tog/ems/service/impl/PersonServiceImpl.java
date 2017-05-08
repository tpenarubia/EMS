package com.tog.ems.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tog.ems.dao.PersonDao;
import com.tog.ems.model.Person;
import com.tog.ems.model.Role;
import com.tog.ems.model.Status;
import com.tog.ems.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonDao personDao;
	
	@Override
	public List<Person> getPeopleList() {
		return personDao.listAllRecord();
	}

	@Override
	public void addPerson(String firstName, String lastName, Role role, Date createdAt,
			String createdBy, Status status) {
		
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setRole(role);
		person.setCreatedAt(createdAt);
		person.setCreatedBy(createdBy);
		person.setStatus(status);
		
		personDao.save(person);
	}

	@Override
	public void updatePerson(Long persId, String firstName, String lastName, Role role,
			Date updatedAt, String modifiedBy, Status status) {
		
		Person person = personDao.findById(persId);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setRole(role);
		person.setUpdatedAt(updatedAt);
		person.setModifiedBy(modifiedBy);
		person.setStatus(status);
		
		personDao.update(person);
	}

	@Override
	public boolean deletePerson(Long id) {
		boolean deleted = false;
		Person person = personDao.findById(id);
		
		if(person != null && person.getId() > 0){
			personDao.delete(person);
			deleted = true;
		}
		
		return deleted;
	}

}
