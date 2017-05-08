package com.tog.ems.dao.impl;

import org.springframework.stereotype.Repository;

import com.tog.ems.dao.RoleDao;
import com.tog.ems.model.Role;

@Repository(value="roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

}
