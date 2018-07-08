package com.webapp.VotingSystem.controllers;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.VotingSystem.entity.VideoGames;
import com.webapp.VotingSystem.repo.VotingOptRepo;


@Controller
public class VotingOptController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	VotingOptRepo votingopt;
	
	@RequestMapping("/show_results")
	public String displayResults(@RequestBody String name, Model model) {
		logger.info("in show results");
		logger.info(name.toString());
		
		VideoGames vd = votingopt.findByName(name);		
		vd.setNo_of_votes(vd.getNo_of_votes()+1);
		votingopt.save(vd);
		
		List<VideoGames> videogames = votingopt.findAll();
		model.addAttribute("videogames",videogames);
		//model.addAttribute("voting results: ", votingopt.findAll());
		return "/results.html";
		
	}
	
}
