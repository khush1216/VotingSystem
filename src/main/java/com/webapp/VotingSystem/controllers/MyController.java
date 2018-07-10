package com.webapp.VotingSystem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.webapp.VotingSystem.entity.Person;
import com.webapp.VotingSystem.repo.Repositories;

//Controller class for Person- checks if person is logging in again within 24 hours, etc.


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
				
		if(person != null && (System.currentTimeMillis() - person.getInTime() < 86400000)) {
			long diff = person.getInTime() - System.currentTimeMillis();
			logger.info(Long.toString(diff));
			return "/cannotVote.html";
		}
		else if(person == null && !name.equals("username=")) {
			Person newPerson = new Person(name,System.currentTimeMillis());
			repo.save(newPerson);
			return "/frontend.html";
		}
		
		else if(name.equals("username=")) {
			return "InvalidName.html";
		}
		
		//if person exists and 24 hours are up.
		else {
			person.setInTime(System.currentTimeMillis());
			repo.save(person);
			return "/frontend.html";
		}
	}
	

}
