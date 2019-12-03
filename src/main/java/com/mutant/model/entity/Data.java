package com.mutant.model.entity;

public class Data {

	private String count_human_dna;
	private String count_mutant_dna;
	private double ratio;

	public Data() {
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public String getCount_human_dna() {
		return count_human_dna;
	}

	public void setCount_human_dna(String count_human_dna) {
		this.count_human_dna = count_human_dna;
	}

	public String getCount_mutant_dna() {
		return count_mutant_dna;
	}

	public void setCount_mutant_dna(String count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}
}
