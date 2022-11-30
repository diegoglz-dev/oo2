package roo2;
/*
 * Director Class
 */
public class CreatorCipher {
	private CipherBuilder cipherBuilder;
	
	public CreatorCipher(String inputText) {
		String[] params = inputText.split(",");
		if (params[0].equals("CesarCipher")) {
			ConcreteCipherBuilder cesar = new ConcreteCipherBuilder(params);
			setCipherBuilder(cesar);
			cesar.buildCesarCipher();
		} else if (params[0].equals("VigenereCipher")) {
			ConcreteCipherBuilder vigenere = new ConcreteCipherBuilder(params);
			setCipherBuilder(vigenere);
			vigenere.buildVigenereCipher();
		} else if (params[0].equals("RailFenceCipher")) {
			ConcreteCipherBuilder railFence = new ConcreteCipherBuilder(params);
			setCipherBuilder(railFence);
			railFence.buildRailFenceCipher();
		} else if (params[0].equals("TranspositionCipher")) {
			ConcreteCipherBuilder trasposition = new ConcreteCipherBuilder(params);
			setCipherBuilder(trasposition);
			trasposition.buildTranspositionCipher();
		}
	}

	public CipherBuilder getCipherBuilder() {
		return cipherBuilder;
	}

	public void setCipherBuilder(CipherBuilder cipherBuilder) {
		this.cipherBuilder = cipherBuilder;
	}
	
	public String encryptMessage(String message) {
		return getCipherBuilder().getRealCipher().cipher(message);
	}
	
	public String decryptMessage(String message) {
		return getCipherBuilder().getRealCipher().decipher(message);
	}
}
