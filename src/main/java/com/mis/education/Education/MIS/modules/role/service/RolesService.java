package com.mis.education.Education.MIS.modules.role.service;


import com.mis.education.Education.MIS.repositories.roles.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {
	
	@Autowired
	private RolesRepository rolesRepository;


	public RolesRepository getRolesRepository() {
		return rolesRepository;
	}

	public void setRolesRepository(RolesRepository rolesRepository) {
		this.rolesRepository = rolesRepository;
	}





}
