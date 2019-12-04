package com.mutant.model.entity;

public class DataArray {
	private String oneDna;
	private String[] dna;
	
	public DataArray() {
		
	}

	public DataArray(String[] dna) {
		super();
		this.dna = dna;
	}

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}
	/***
	 * Genera una matrizNxN
	 * @return	Char[][]
	 */
	public char[][] getMatrizDna() {
		int n = this.dna.length;
		char matriz[][] = new char[n][n];
		int cont = 0;

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				matriz[x][y] = dna[x].charAt(cont);
				cont++;
			}
			cont = 0;
		}
		return matriz;
	}

	public String getOneDna(int i) {
		oneDna = this.dna[i];
		return oneDna;
	}
	public void setOneDna(String oneDna) {
		this.oneDna = oneDna;
	}
}
