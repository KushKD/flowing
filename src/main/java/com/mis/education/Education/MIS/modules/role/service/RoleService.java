package com.mis.education.Education.MIS.modules.role.service;


import com.mis.education.Education.MIS.modules.role.entity.RolesEntity;
import com.mis.education.Education.MIS.repositories.roles.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
	
	@Autowired
	private RolesRepository rolesRepository;


	public RolesRepository getRolesRepository() {
		return rolesRepository;
	}

	public void setRolesRepository(RolesRepository rolesRepository) {
		this.rolesRepository = rolesRepository;
	}

	public RolesEntity saveRole(RolesEntity entity) {
		return rolesRepository.save(entity);
		
	}


	public Boolean checkRoleName(String roleName) {
		return rolesRepository.checkRole(roleName);
	}

	public Optional<RolesEntity> getRoleDetails(String id){
		return rolesRepository.findById(Long.parseLong(id));
	}
}
