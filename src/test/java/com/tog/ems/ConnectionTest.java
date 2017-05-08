package com.tog.ems;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tog.ems.dao.PersonDao;
import com.tog.ems.dao.RoleDao;
import com.tog.ems.model.Person;
import com.tog.ems.model.Role;
import com.tog.ems.model.Status;
import com.tog.ems.service.PersonService;
import com.tog.ems.service.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ConnectionTest {

	PersonDao persDao;
	
	RoleDao roleDao;
	
	
	
	@Autowired
	PersonService personService;
	
	@Autowired
	RoleService roleService;
	
	@Before
	public void TestConnection() {
	  AbstractApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	     persDao = (PersonDao)appContext.getBean("personDao");
	     
	     roleDao = (RoleDao)appContext.getBean("roleDao");
	     
	}
	
	@Test
	public void InsertTest(){
		
		Date date = new Date();
		String role = "MANAGER";
		String description = "MANAGES PEOPLE";
		Date createdAt = date;
		String createdBy = "Moti";
		
		Role personRole = new Role();
		personRole.setRole(role);
		personRole.setDescription(description);
		personRole.setCreatedAt(createdAt);
		personRole.setCreatedBy(createdBy);
		
		//roleDao.save(personRole);
        roleService.addRole(role, description, createdAt, createdBy, Status.ACTIVE);
	}
}
