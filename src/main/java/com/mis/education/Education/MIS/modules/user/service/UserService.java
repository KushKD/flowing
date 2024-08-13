package com.mis.education.Education.MIS.modules.user.service;

import com.mis.education.Education.MIS.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;


	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	
	public UserEntity getUserDetails(Long mobileNumber) {
		return userRepository.getUserDetails(mobileNumber);
		
	}

	public UserEntity saveUser(UserEntity entity) {
		return userRepository.save(entity);

	}



	public UserEntity getUserDetailsViaUsername(String username){
		return userRepository.findByUsername(username);
	}






}
