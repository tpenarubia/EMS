package com.tog.ems.dao.impl;

import org.springframework.stereotype.Repository;

import com.tog.ems.dao.PersonDao;
import com.tog.ems.model.Person;
	
@Repository(value="personDao")
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao{

}
