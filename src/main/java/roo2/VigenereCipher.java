package roo2;

public class VigenereCipher extends SubstitutionCipher {
	CharRing keyword;
    
	public VigenereCipher(String kword, String inputAlphabet) {
		alphabet = new char[inputAlphabet.length()];
		inputAlphabet.getChars(0,inputAlphabet.length(), alphabet, 0);
		setKeyword(kword);
	};

	public VigenereCipher() {
		super();
		keyword = new CharRing("a");
	};

	public void setKeyword(String srcString) {
		keyword = new CharRing(srcString);
	}
	
	@Override
	protected int currentOffset() {
		return keyword.next() - alphabet[0];
	}
}