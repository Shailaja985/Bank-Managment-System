package com.bms.app.service;

import java.util.concurrent.ThreadLocalRandom;

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
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//signUpDto.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
		BeanUtils.copyProperties(userDto, userEntity);
//		userDto.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
//		
//		ModelMapper modelMapper=new ModelMapper();
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		UserEntity userEntity=modelMapper.map(userDto , UserEntity.class);
		userRepositoryImpl.save(userEntity);
		
		return userEntity;

	}


}
