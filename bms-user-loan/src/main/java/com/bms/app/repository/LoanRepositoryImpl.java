package com.bms.app.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.bms.app.model.LoanDetails;

@Repository
public class LoanRepositoryImpl {
	
	@Autowired
	private EntityManager em;
	
	public LoanDetails save(LoanDetails loanDetails) {
		Session session = em.unwrap(Session.class);
		session.persist(loanDetails);
		return loanDetails;
	}

}
