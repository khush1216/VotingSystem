package com.webapp.VotingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="videogames")
public class VideoGames {
	
	@Id
	@Column(name="game_name")
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNo_of_votes() {
		return no_of_votes;
	}

	public void setNo_of_votes(Long no_of_votes) {
		this.no_of_votes = no_of_votes;
	}

	@Column(name="no_of_votes")
	private Long no_of_votes;
	
	public VideoGames(String name, long votes) {
		super();
		this.name = name;
		this.no_of_votes = votes;	
				
	}
	
	public VideoGames() {
		super();
	}

}
