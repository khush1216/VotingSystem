package com.webapp.VotingSystem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.webapp.VotingSystem.entity.Person;
import com.webapp.VotingSystem.repo.Repositories;

@Controller
public class MyController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Repositories repo;
	
	@RequestMapping("/")
	public String votePage() {
		return "webuser.html";
	}
	
	@RequestMapping("/proceed_to_vote")
	public String proceedToVote(@RequestBody String name) {
		
		Person person = repo.findByName(name);
		
		logger.info(name.toString());
		
		if(person != null && person.getInTime() - System.currentTimeMillis() < 86400000) {
			//person.setInTime(System.currentTimeMillis());
			return "/cannotVote.html";
		}
		else if(person == null) {
			Person newPerson = new Person(name,System.currentTimeMillis());
			repo.save(newPerson);
			return "/frontend.html";
		}
		
		//if person exists and 24 hours are up.
		else {
			person.setInTime(System.currentTimeMillis());
			repo.save(person);
			return "/frontend.html";
		}
	}
	

}
