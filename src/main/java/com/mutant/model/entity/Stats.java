package com.mutant.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stats")
public class Stats {

	@Column(nullable = true)
	private String mutantDna;
	

	@Column(nullable = true)
	private String humanDna;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	public Stats() {
	}

	public Stats(String mutantDna, String humanDna) {
		super();
		this.mutantDna = mutantDna;
		this.humanDna = humanDna;
	}


	public String getMutantDna() {
		return mutantDna;
	}

	public void setMutantDna(String mutantDna) {
		this.mutantDna = mutantDna;
	}

	public String getHumanDna() {
		return humanDna;
	}

	public void setHumanDna(String humanDna) {
		this.humanDna = humanDna;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



}
