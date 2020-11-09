package com.bms.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bms.app.data.UserEntity;
import com.bms.app.shared.UserDto;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	UserDto save(UserDto userDto);
}
