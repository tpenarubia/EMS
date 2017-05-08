package com.tog.ems.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tog.ems.dao.RoleDao;
import com.tog.ems.model.Role;
import com.tog.ems.model.Status;
import com.tog.ems.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<Role> getRoleList() {
	  return roleDao.listAllRecord();
	}

	@Override
	public void addRole(String role, String description, Date createdAt, String createdBy,
			Status status) {
		
		Role personRole = new Role();
		personRole.setRole(role);
		personRole.setDescription(description);
		personRole.setCreatedAt(createdAt);
		personRole.setCreatedBy(createdBy);
		personRole.setStatus(status);
		
		roleDao.save(personRole);
	}

	@Override
	public void updateRole(Long id, String role, String description, Date updatedAt,
			String modifiedBy, Status status) {
		// TODO Auto-generated method stub
		Role personRole = roleDao.findById(id);
		
		personRole.setRole(role);
		personRole.setDescription(description);
		personRole.setUpdatedAt(updatedAt);
		personRole.setModifiedBy(modifiedBy);
		personRole.setStatus(status);
		
		roleDao.update(personRole);
	}

	@Override
	public boolean deleteRole(Long id) {
	   boolean deleted = false;
	   Role personRole = roleDao.findById(id);
	   
	   if(personRole != null && personRole.getId() > 0){
		   roleDao.delete(personRole);
		   deleted = true;
	   }
	   
	   return deleted;
	}

}
