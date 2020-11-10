package com.bms.app.service;



import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bms.app.data.UserEntity;


import com.bms.app.repository.UserRepositoryImpl;
import com.bms.app.shared.UserDto;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepositoryImpl userRepositoryImpl;
	

	@Override
	public UserEntity CreateUser(UserDto userDto) {
		
		UserEntity  userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userRepositoryImpl.save(userEntity);
		return userEntity;

	}


}
