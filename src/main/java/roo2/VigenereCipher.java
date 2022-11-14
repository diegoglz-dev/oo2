package roo2;

public class VigenereCipher implements Cipher {
	char[] alphabet;
	CharRing keyword;
    
	public VigenereCipher(String inputAlphabet, String kword) {
		alphabet = new char[inputAlphabet.length()];
		inputAlphabet.getChars(0,inputAlphabet.length(), alphabet, 0);
		setKeyword(kword);
	};

	public VigenereCipher() {
		String inputAlphabet = "abcdefghijklmnopqrstuvwxyz";
		alphabet = new char[inputAlphabet.length()];
		inputAlphabet.getChars(0,inputAlphabet.length(), alphabet, 0);
		keyword = new CharRing("a");
	};

	public String cipher(String inputText) {
		char[] result = new char[inputText.length()];
		inputText.getChars(0, inputText.length(), result, 0);
		
		for (int index = 0; index < result.length; index++)
			result[index] = cipherOrDecipherChar(result[index], true);
		return new String(result);
	};

	public String decipher(String inputText) {
		char[] result = new char[inputText.length()];
		inputText.getChars(0, inputText.length(), result, 0);
		
		for (int index = 0; index < result.length; index++)
			result[index] = cipherOrDecipherChar(result[index], false);
		return new String(result);
	};
	
	private char cipherOrDecipherChar(char inputChar, boolean cipher) {
		int offset;
		char result = inputChar;
		
		int index = searchCharacterInAlphabet(inputChar);
        
		if(index >= 0) {
			if (cipher) {
				offset = index + this.currentOffset();
				
				if(offset < alphabet.length) {
					result = alphabet[offset];
				} else {
	            	result = alphabet[offset - alphabet.length];
	            }
			} else {
				offset = index - this.currentOffset();
	            
				if(offset >= 0) {
					result = alphabet[offset];
				} else {
					result = alphabet[alphabet.length + offset];
				}
			}
		}
		return result;
	}
	
	private int searchCharacterInAlphabet(char inputChar) {
    	return java.util.Arrays.binarySearch(alphabet, inputChar);
    }
    
	public void setKeyword(String srcString) {
		keyword = new CharRing(srcString);
	}
    
	private int currentOffset() {
		return keyword.next() - alphabet[0];
	}
}