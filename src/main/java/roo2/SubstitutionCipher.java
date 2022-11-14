package roo2;

public abstract class SubstitutionCipher implements Cipher {
	protected char[] alphabet;

	public SubstitutionCipher() {
		String inputAlphabet = "abcdefghijklmnopqrstuvwxyz";
		alphabet = new char[inputAlphabet.length()];
		inputAlphabet.getChars(0,inputAlphabet.length(), alphabet, 0);
	}

	public String cipher(String inputText) {
		char[] result = new char[inputText.length()];
		inputText.getChars(0, inputText.length(), result, 0);
		
		for (int index = 0; index < result.length; index++)
			result[index] = cipherOrDecipherChar(result[index], true);
		return new String(result);
	}

	public String decipher(String inputText) {
		char[] result = new char[inputText.length()];
		inputText.getChars(0, inputText.length(), result, 0);
		
		for (int index = 0; index < result.length; index++)
			result[index] = cipherOrDecipherChar(result[index], false);
		return new String(result);
	}

	private char cipherOrDecipherChar(char inputChar, boolean cipher) {
		int offset;
		char result = inputChar;
		
		int index = searchCharacterInAlphabet(inputChar);
	    
		if(index >= 0) {
			if (cipher) {
				offset = index + this.currentOffset();
				
				result = hookCipherChar(offset);
			} else {
				offset = index - this.currentOffset();
	            
				result = hookDecipherChar(offset);
			}
		}
		return result;
	}
	
	private char hookCipherChar(int offset) {
		if(offset < alphabet.length) {
			return alphabet[offset];
		} else {
        	return alphabet[offset - alphabet.length];
        }
	}
	
	private char hookDecipherChar(int offset) {
		if(offset >= 0) {
			return alphabet[offset];
		} else {
			return alphabet[alphabet.length + offset];
		}
	}

	private int searchCharacterInAlphabet(char inputChar) {
		return java.util.Arrays.binarySearch(alphabet, inputChar);
	}

	protected abstract int currentOffset();

}