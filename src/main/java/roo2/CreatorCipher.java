package roo2;
/*
 * Director Class
 */
public class CreatorCipher {
	private CipherBuilder cipherBuilder;
	
	public CreatorCipher(String inputText) {
		String[] params = inputText.split(",");
		if (params[0].equals("CesarCipher")) {
			setCipherBuilder(new CesarCipherBuilder(params));
		} else if (params[0].equals("VigenereCipher")) {
			setCipherBuilder(new VigenereCipherBuilder(params));
		} else if (params[0].equals("RailFenceCipher")) {
			setCipherBuilder(new RailFenceCipherBuilder(params));
		} else if (params[0].equals("TranspositionCipher")) {
			setCipherBuilder(new TranspositionCipherBuilder(params));
		}
	}

	public CipherBuilder getCipherBuilder() {
		return cipherBuilder;
	}

	public void setCipherBuilder(CipherBuilder cipherBuilder) {
		this.cipherBuilder = cipherBuilder;
	}
	
	public String cipher(String message) {
		return getCipherBuilder().getRealCipher().cipher(message);
	}
	
	public String decipher(String message) {
		return getCipherBuilder().getRealCipher().decipher(message);
	}
}
