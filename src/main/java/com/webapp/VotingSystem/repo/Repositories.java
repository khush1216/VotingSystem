package com.webapp.VotingSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.VotingSystem.entity.Person;

@Repository
public interface Repositories extends JpaRepository<Person,Long> {

	public Person findByName(String name);
	
	
}
