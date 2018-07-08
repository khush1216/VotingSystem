package com.webapp.VotingSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.VotingSystem.entity.VideoGames;

@Repository
public interface VotingOptRepo extends JpaRepository<VideoGames,Long> {
	
	public VideoGames findByName(String name);

}
