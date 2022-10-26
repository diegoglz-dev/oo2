package roo2;

import roo2.BouncingIndex;

public class  RailFenceCipher implements Cipher {
    String[] rails;
    BouncingIndex bouncingIndex;

    public  RailFenceCipher(int railCount){
        rails = new String[railCount];
        for (int index = 0; index < rails.length; index++)
        	rails[index] = "";
        bouncingIndex = new BouncingIndex(railCount);

    };

    public String cipher(String inputText){
        String result = "";
        char inputChar[] = new char[inputText.length()];
        inputText.getChars(0,inputText.length(), inputChar, 0);
        for(int index = 0; index < inputText.length(); index++) {
            int rIndex = bouncingIndex.next();            
            rails[rIndex] += inputChar[index]; 
        }
        for(int index = 0; index < rails.length; index ++) {
            result += rails[index ];
        }
        return result; 
    }; 
   
	@Override
	public String decipher(String inputText) {
		return this.decode(inputText, this.rails.length);
	}
	
	
	private int getTerm(int iteration, int row, int size) {
        if ((size == 0) || (size == 1)) {
            return 1;
        }
        if((row == 0) || (row == size - 1)) {
            return (size - 1) * 2;
        }

        if (iteration % 2 == 0) {
            return (size - 1 - row) * 2;
        }
        return 2 * row;
    }
	
	public String decode(String message, int key) {
        if (key < 0) {
            throw new ArithmeticException("No se puede ingresar numeros de rieles negativos.");
        }
        StringBuilder decodedMessage = new StringBuilder(message);
        int currPosition = 0;
        for(int row = 0; row < key; row++) {
            int iter = 0;
            for(int i = row; i < message.length(); i += getTerm(iter++, row, key)) {
                decodedMessage.setCharAt(i, message.charAt(currPosition++));
            }
        }
        return decodedMessage.toString();
    }
}