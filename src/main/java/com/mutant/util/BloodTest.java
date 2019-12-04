package com.mutant.util;

import java.util.ArrayList;
import java.util.List;

public class BloodTest {

	/***
	 * Verifica que una matriz cuadrada contenga ADN Mutante. Controla que sea en una cadena de 4 apariciones
	 *  del siguiente conjunto de caracteres: {A,T,C,G}
	 * @param matNxN	Matriz de NxN, tal que N es entero
	 * @param n			Entero que contiene la cantidad de columnas y filas de la matriz matNxN
	 * @return	Boolean true / false
	 */
	public List<String> isMutant(char[][] matNxN, int n) {
		char matriz[][] = new char[10][4];
		List<String> listaMutante = new ArrayList<>();
		for (int i = 0; i < n - 3; i++) {
			for (int j = 0; j < n - 3; j++) {
				matriz[0][0] = matNxN[i][j];
				matriz[0][1] = matNxN[i][j + 1];
				matriz[0][2] = matNxN[i][j + 2];
				matriz[0][3] = matNxN[i][j + 3];

				matriz[1][0] = matNxN[i + 1][j];
				matriz[1][1] = matNxN[i + 1][j + 1];
				matriz[1][2] = matNxN[i + 1][j + 2];
				matriz[1][3] = matNxN[i + 1][j + 3];

				matriz[2][0] = matNxN[i + 2][j];
				matriz[2][1] = matNxN[i + 2][j + 1];
				matriz[2][2] = matNxN[i + 2][j + 2];
				matriz[2][3] = matNxN[i + 2][j + 3];

				matriz[3][0] = matNxN[i + 3][j];
				matriz[3][1] = matNxN[i + 3][j + 1];
				matriz[3][2] = matNxN[i + 3][j + 2];
				matriz[3][3] = matNxN[i + 3][j + 3];

				matriz[4][0] = matNxN[i][j];
				matriz[4][1] = matNxN[i + 1][j];
				matriz[4][2] = matNxN[i + 2][j];
				matriz[4][3] = matNxN[i + 3][j];

				matriz[5][0] = matNxN[i][j + 1];
				matriz[5][1] = matNxN[i + 1][j + 1];
				matriz[5][2] = matNxN[i + 2][j + 1];
				matriz[5][3] = matNxN[i + 3][j + 1];

				matriz[6][0] = matNxN[i][j + 2];
				matriz[6][1] = matNxN[i + 1][j + 2];
				matriz[6][2] = matNxN[i + 2][j + 2];
				matriz[6][3] = matNxN[i + 3][j + 2];

				matriz[7][0] = matNxN[i][j];
				matriz[7][1] = matNxN[i + 1][j + 3];
				matriz[7][2] = matNxN[i + 2][j + 3];
				matriz[7][3] = matNxN[i + 3][j + 3];

				matriz[8][0] = matNxN[i][j];
				matriz[8][1] = matNxN[i + 1][j + 1];
				matriz[8][2] = matNxN[i + 2][j + 2];
				matriz[8][3] = matNxN[i + 3][j + 3];

				matriz[9][0] = matNxN[i][j + 3];
				matriz[9][1] = matNxN[i + 1][j + 2];
				matriz[9][2] = matNxN[i + 2][j + 1];
				matriz[9][3] = matNxN[i + 3][j];
				listaMutante.addAll(this.analizar10x4(matriz));
			}
		}
		return listaMutante;
	}

	/***
	 * Analisis de una matriz[10][4] para detectar valores iguales entre sus caractares dada sus filas.
	 * @param matrix	Matriz de NxN, tal que N es entero
	 * @return	List<String> contiene un listado de String si y solo si se encontro recurrencia de valores
	 */
	
	public List<String> analizar10x4(char[][] matNxN) {
		List<String> lista = new ArrayList<>();
		String auxiliar = null;
		// barrido horizontal
		for (int i = 0; i < 10; i++) {
			if ((matNxN[i][0] == matNxN[i][1]) && (matNxN[i][0] == matNxN[i][2]) && (matNxN[i][0] == matNxN[i][3])) {
				auxiliar = 		String.valueOf(matNxN[i][0]) + 
								String.valueOf(matNxN[i][1]) + 
								String.valueOf(matNxN[i][2]) + 
								String.valueOf(matNxN[i][3]);
				lista.add(auxiliar);
			}
		}
		return lista;
	}
	/***
	 * Genera una matrizNxN cuadrada a partir de un String[]
	 * @param secuencia	Es un String[]
	 * @return	Char[][]
	 */
	// armado de matriz a partir de una secuencia de datos strings
		public char[][] armaMatriz(String[] secuencia) {
			int n = secuencia.length;
			char matriz[][] = new char[n][n];
			int cont = 0;

			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					matriz[x][y] = secuencia[x].charAt(cont);
					cont++;
				}
				cont = 0;
			}
			return matriz;
		}
}