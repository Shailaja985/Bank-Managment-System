package com.bms.app.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.app.data.UserEntity;

@Repository
public class UserRepositoryImpl {
	
	@Autowired
	private EntityManager em;
	
	public UserEntity save(UserEntity userEntity) {
		Session session = em.unwrap(Session.class);
		session.persist(userEntity);
		return userEntity;
	}

	
}