package roo2;

public class CesarCipher implements Cipher {
	char[] alphabet;
	int jump = 0;
    
	public CesarCipher(int number, String inputAlphabet) {
		alphabet = new char[inputAlphabet.length()];
		inputAlphabet.getChars(0,inputAlphabet.length(), alphabet, 0);
		jump = number;
	};
	
	public CesarCipher(int number) {
		String inputAlphabet = "abcdefghijklmnopqrstuvwxyz";
		alphabet = new char[inputAlphabet.length()];
		inputAlphabet.getChars(0,inputAlphabet.length(), alphabet, 0);
		jump = number;
    };

    public String cipher(String inputText) {
    	char[] result = new char[inputText.length()] ;
    	inputText.getChars(0, inputText.length(), result, 0);
    	
    	for (int index = 0; index < result.length; index++)
    		result[index] = cipherOrDecipherChar(result[index], true);
    	return new String(result);
    };

	public String decipher(String inputText) {
    	char[] result = new char[inputText.length()] ;
    	inputText.getChars(0, inputText.length(), result, 0);
    	
    	for (int index = 0; index < result.length; index++)
    		result[index] = cipherOrDecipherChar(result[index], false);
    	return new String(result);
    };
    
    private char cipherOrDecipherChar(char inputChar, boolean cipher) {
    	int offset;
    	char result = inputChar;
    	int index = searchCharacterInAlphabet(inputChar);
    	
    	if (index >= 0) {
    		if (cipher) {
    			offset = index + jump;
            	
                if (offset < alphabet.length) {
                	result = alphabet[offset];
                }
                else {
                	result = alphabet[offset - alphabet.length];
                }
    		} else {
    			offset = index - jump;
                
                if (offset >= 0) {
                    result = alphabet[offset];
                }
                else {
                    result = alphabet[alphabet.length + offset];
                }
    		}
    	}
    	return result;
	}
    
    private int searchCharacterInAlphabet(char inputChar) {
    	return java.util.Arrays.binarySearch(alphabet,inputChar);
    }
}