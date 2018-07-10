package com.webapp.VotingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//table for Person - id = name, log in time in milliseconds

@Entity
@Table(name="person")
public class Person {

//	@Id
//	@Column(name="id")
//	private Long id;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
	
	@Id
	@Column(name="person_name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="voting_time")
	private Long inTime;

	public long getInTime() {
		return inTime;
	}

	public void setInTime(long inTime) {
		this.inTime = inTime;
	}

	public Person(String name, Long inTime) {
		super();
		//this.id = id;
		this.name = name;
		this.inTime = inTime;
	}
	
	public Person() {
		super();
	}
}
