package com.bms.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.app.data.UserEntity;
import com.bms.app.model.LoginModel;
import com.bms.app.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserEntity login(LoginModel loginModel) {
		UserEntity user = loginRepository.findByUserName((loginModel.getUserName()));
		if (user == null) {
			throw new RuntimeException("user does not exist.");
		}
		
		if (!user.getPassword().equals((loginModel.getPassword()))) {
		
			throw new RuntimeException("Password mismatch.");
		}
		
		return user;
	}

}
