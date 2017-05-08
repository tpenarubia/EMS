package com.tog.ems.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tog.ems.model.Role;
import com.tog.ems.model.Status;

@Service
@Transactional
public interface RoleService {

	List<Role> getRoleList();
	
	void addRole(String role, String description,
			Date createdAt, String createdBy, Status status);
	
	void updateRole(Long id, String role, String description,
			 Date updatedAt, String modifiedBy, Status status);
	
	boolean deleteRole(Long id);
}
