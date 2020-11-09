package com.bms.app.service;

import com.bms.app.data.UserEntity;
import com.bms.app.model.UserModel;
import com.bms.app.shared.UserDto;


public interface UserService {
	public UserEntity CreateUser(UserDto userDto);
}
