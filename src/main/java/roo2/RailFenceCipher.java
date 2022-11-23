package roo2;

public class RailFenceCipher implements Cipher {
	String[] rails;
	BouncingIndex bouncingIndex;

	public RailFenceCipher(int railCount){
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
			int railIndex = bouncingIndex.next();            
			rails[railIndex] += inputChar[index];
		}
		for(int index = 0; index < rails.length; index ++) {
			result += rails[index ];
		}
		return result; 
	};
	
	public String decipher(String inputText) {
		int railCount = this.rails.length;
		if (railCount < 0) {
            throw new ArithmeticException("No se puede ingresar numeros de rieles negativos.");
        }
        StringBuilder decodedMessage = new StringBuilder(inputText);
        int currentPosition = 0;
        for(int railIndex = 0; railIndex < railCount; railIndex++) {
            int iteration = 0;
            for(int index = railIndex; index < inputText.length(); index += getTerm(iteration++, railIndex, railCount)) {
                decodedMessage.setCharAt(index, inputText.charAt(currentPosition++));
            }
        }
        return decodedMessage.toString();
	}
	
	private int getTerm(int iteration, int railIndex, int railCount) {
		if ((railCount == 0) || (railCount == 1)) {
			return 1;
        }
		
		if((railIndex == 0) || (railIndex == railCount - 1)) {
			return (railCount - 1) * 2;
		}
		
		if (iteration % 2 == 0) {
			return (railCount - 1 - railIndex) * 2;
		}
		return 2 * railIndex;
	}
}