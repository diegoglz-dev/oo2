package roo2;

/*
 * Director Class
 */
public class CreatorCipher {
	private Cipher cipher;
	
	public CreatorCipher(String inputText) {
		String[] params = inputText.split(",");
		if (params[0].equals("CesarCipher")) {
			ConcreteCipherBuilder cesar = new ConcreteCipherBuilder(params);
			setCipher(cesar.builCesarCipher());
		} else if (params[0].equals("VigenereCipher")) {
			ConcreteCipherBuilder vigenere = new ConcreteCipherBuilder(params);
			setCipher(vigenere.buildVigenereCipher());
		} else if (params[0].equals("RailFenceCipher")) {
			ConcreteCipherBuilder railFence = new ConcreteCipherBuilder(params);
			setCipher(railFence.buildRailFenceCipher());
		} else if (params[0].equals("TranspositionCipher")) {
			ConcreteCipherBuilder trasposition = new ConcreteCipherBuilder(params);
			setCipher(trasposition.buildTranspositionCipher());
		} else if (params[0].equals("ComplexCipher")) {
			ConcreteCipherBuilder complex = new ConcreteCipherBuilder(params);
			setCipher(complex.buildComplexCipher());
		}
	}
	
	public void addCipher(Cipher newCipher) {
		((ComplexCipher) getCipher()).addCipher(newCipher);
	}

	public Cipher getCipher() {
		return cipher;
	}

	public void setCipher(Cipher cipher) {
		this.cipher = cipher;
	}

	public String encryptMessage(String message) {
		return cipher.cipher(message);
	}
	
	public String decryptMessage(String message) {
		return cipher.decipher(message);
	}
}
