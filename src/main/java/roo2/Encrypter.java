package roo2;

/**
 * Factory Method.
 */

public class Encrypter {
	
	public Cipher getCipher(String cipher) {
		if (cipher.equalsIgnoreCase("CesarCipher")) {
			return new CesarCipher(1);
		} else if (cipher.equalsIgnoreCase("RailFenceCipher")) {
			return new RailFenceCipher(0);
		} else if (cipher.equalsIgnoreCase("VigenereCipher")) {
			return new VigenereCipher();
		}
		return null;
	}
	
	public Cipher getCipher(String cipher, int n) {
		if (cipher.equalsIgnoreCase("CesarCipher")) {
			return new CesarCipher(n);
		} else if (cipher.equalsIgnoreCase("RailFenceCipher")) {
			return new RailFenceCipher(n);
		} 
		return null;
	}
}
