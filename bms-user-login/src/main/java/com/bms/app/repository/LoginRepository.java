package com.bms.app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.bms.app.data.UserEntity;

@Repository
public interface LoginRepository extends CrudRepository<UserEntity, Long> {
	
	 UserEntity findByUserName(String userName);

}
