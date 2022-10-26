package roo2;

//import roo2.Cipher;

public class  CesarCipher implements Cipher {
    char[] alphabet;
    int jump = 0;
    
    public CesarCipher(int number, String inputAlphabet){
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

    public String cipher(String inputText){
        char[] result = new char[inputText.length()] ;
        inputText.getChars(0, inputText.length(), result, 0);

        for (int index = 0; index < result.length; index++)
        	result[index] = cipherChar(result[index]);
        return new String(result); //alphabet[inputText.length()];
    }; 

    public String decipher(String inputText){
        char[] result = new char[inputText.length()] ;
        inputText.getChars(0, inputText.length(), result, 0);

        for (int index = 0; index < result.length; index++)
        	result[index] = decipherChar(result[index]);
        return new String(result);
    }; 

    private char cipherChar(char inputChar) {
        int offset;
        char result;
        int index = java.util.Arrays.binarySearch(alphabet,inputChar);
        
        if (index < 0) {
        	result = inputChar;
        }
        else {
        	offset = index + jump;
        	
            if (offset < alphabet.length) {
            	result = alphabet[offset];
            }
            else {
            	result = alphabet[offset - alphabet.length];
            }
        }
        return result;
    };

    private char decipherChar(char inputChar) {
        int offset;
        char result;
        int index = java.util.Arrays.binarySearch(alphabet,inputChar);
        
        if (index < 0) {
            result = inputChar;
        }
        else { 
            offset = index - jump;
            
            if (offset >= 0) {
                result = alphabet[offset];
            }
            else {
                result = alphabet[alphabet.length + offset];
            }
        }
        return result;
    };
}