package com.bms.app.service;

import com.bms.app.data.UserEntity;
import com.bms.app.model.LoginModel;

public interface LoginService {
	UserEntity login(LoginModel loginModel);
}
