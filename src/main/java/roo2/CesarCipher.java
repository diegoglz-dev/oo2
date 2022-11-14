package roo2;

public class CesarCipher extends SubstitutionCipher {
	int jump = 0;
    
	public CesarCipher(int number, String inputAlphabet) {
		alphabet = new char[inputAlphabet.length()];
		inputAlphabet.getChars(0,inputAlphabet.length(), alphabet, 0);
		jump = number;
	};
	
	public CesarCipher(int number) {
		super();
		jump = number;
    }

	@Override
	protected int currentOffset() {
		return this.jump;
	};
}