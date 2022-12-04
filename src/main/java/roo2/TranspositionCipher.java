package roo2;

import java.util.ArrayList;
import java.util.Collections;

public class TranspositionCipher implements Cipher {
	char[] key;
	
	public TranspositionCipher(String inputText) {
		key = inputText.toCharArray();
	}

	@Override
	public String cipher(String inputText) {
		// Crea array segun el mensaje que viene por parametro
		char[] message = inputText.toCharArray();
		// Crea matriz apartir del mensaje
		char[][] matriz = generateMatrixOfMessage(message);
		// Reordenar columnas de acuerdo a posicion de clave respecto al alfabeto
		ArrayList<Character> keyOrdered = reorderKeyWord();
		// Crea una nueva matriz ordenada en columnas segun la palabra clave ordenada segun alfabeto
		char[][] matrizNueva = reorderArrayWithKeyWordOrdered(message, matriz, keyOrdered);
		// Retorno un string generado despues de recorrer la matriz
		return traverseArray(matrizNueva);
	}

	/**
	 * @param message
	 * @param matriz
	 * @param keyOrdered
	 * @return una nueva matriz ordenada en columnas segun la palabra clave ordenada segun alfabeto
	 */
	private char[][] reorderArrayWithKeyWordOrdered(char[] message, char[][] matriz,
			ArrayList<Character> keyOrdered) {
		char[][] matrizNueva = new char[message.length][key.length];
		for(int i = 0; i < keyOrdered.size(); i++) {
			for(int j = 0; j < key.length; j++) {
				if (keyOrdered.get(i) == key[j]) {
					int newColum = i;
					int oldColum = j;
					
					for (int fila = 0; fila < matriz.length; fila++)
						matrizNueva[fila][newColum] = matriz[fila][oldColum];
				}
			}
		}
		return matrizNueva;
	}

	/**
	 * @return un ArrayList de la palabra clave ordenada segun alfabeto
	 */
	private ArrayList<Character> reorderKeyWord() {
		ArrayList<Character> keyOrdered = new ArrayList<Character>();
		
		for(int i = 0; i < key.length; i++)
			keyOrdered.add(key[i]);
		Collections.sort(keyOrdered);
		return keyOrdered;
	}
	/*
	 * Crea la matriz a partir del mensaje que viene por parametro
	 * En este caso es un array del mensaje
	 */
	private char[][] generateMatrixOfMessage(char[] message) {
		char[][] matriz = new char[message.length][key.length];
		
		for (int x=0; x < matriz.length; x++) {
			  for (int y=0; y < matriz[x].length; y++) {
				  matriz[x][y] = '*';
			  }
		}
		
		int row = 0, columns = 0;
		for(int i = 0; i < message.length; i++) {
			if (columns >= key.length) {
				columns = 0;
				row++;
			}
			
			matriz[row][columns] = message[i];
			columns++;
		}
		
		return matriz;
	}

	private String traverseArray(char[][] matriz) {
		String result = "";
		for(int i = 0; i < matriz.length; i++)
			for (int j = 0; j < key.length; j++) {
				result += matriz[i][j];
			}
		return result.replace("*", "");
	}

	@Override
	public String decipher(String inputText) {
		// Crea array segun el mensaje que viene por parametro
		char[] message = inputText.toCharArray();
		// Crea matriz apartir del mensaje
		char[][] matriz = generateMatrixOfMessage(message);
		// Reordenar columnas de acuerdo a posicion de clave respecto al alfabeto
		ArrayList<Character> keyOrdered = reorderKeyWord();
		// Crea una nueva matriz ordenada en columnas segun la palabra clave ordenada segun alfabeto
		char[][] matrizNueva = reorderArrayWithKeyWord(message, matriz, keyOrdered);
		// Retorno un string generado despues de recorrer la matriz
		return traverseArray(matrizNueva);
	}

	private char[][] reorderArrayWithKeyWord(char[] message, char[][] matriz, ArrayList<Character> keyOrdered) {
		char[][] matrizNueva = new char[message.length][key.length];
		for(int i = 0; i < key.length; i++) {
			for(int j = 0; j < keyOrdered.size(); j++) {
				if (keyOrdered.get(i) == key[j]) {
					int oldColum = i;
					int newColum = j;
					
					for (int fila = 0; fila < matriz.length; fila++)
						matrizNueva[fila][newColum] = matriz[fila][oldColum];
				}
			}
		}
		return matrizNueva;
	}
}
