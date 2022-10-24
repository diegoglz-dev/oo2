package roo2;

import roo2.BouncingIndex;

public class  RailFenceCipher implements Cipher {
    String[] rails;
    BouncingIndex bIndex;

    public  RailFenceCipher(int railCount){
        rails = new String[railCount];
        for (int idx =0; idx < rails.length; idx++)
            rails[idx]="";
        bIndex = new BouncingIndex(railCount);

    };

    public String cipher(String inputText){
        String result = "";
        char inputChar[] = new char[inputText.length()];
        inputText.getChars(0,inputText.length(), inputChar, 0);
        for(int idx =0; idx < inputText.length(); idx++){
            int rIndex= bIndex.next();            
            rails[rIndex]+=  inputChar[idx]; 
        }
        for(int idx=0; idx < rails.length; idx++){
            result += rails[idx];
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
        if((row == 0) || (row == size-1)) { // Max. distance is achieved at the ends and equally (size-1)*2
            return (size-1)*2;
        }

        if (iteration % 2 == 0) { // In the description of the method above this identity is demonstrated
            return (size-1-row)*2;
        }
        return 2*row;
    }
	
	public String decode(String message, int key) {
        if (key < 0) {
            throw new ArithmeticException("Negative key value");
        }
        StringBuilder decodedMessage = new StringBuilder(message);
        int currPosition = 0; // Position in source string
        for(int row = 0; row < key; row++) { // Look rows
            int iter = 0; // The number of the character in the row
            for(int i = row; i < message.length(); i += getTerm(iter++, row, key)) {
                decodedMessage.setCharAt(i, message.charAt(currPosition++));
            }
        }
        return decodedMessage.toString();
    }
}