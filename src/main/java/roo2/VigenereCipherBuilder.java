package roo2;
/*
 * Concrete Builder
 */
public class VigenereCipherBuilder extends CipherBuilder {
	
	public VigenereCipherBuilder(String[] params) {
		setEncrypter(new Encrypter());
		setParams(params);
		initializeCipher();
	}
	
	public void initializeCipher() {
		buildKeyword();
		buildAlphabet();
		if (getEncrypter().getAlphabet() != null) {
			setRealCipher(new VigenereCipher(getEncrypter().getKeyword(), getEncrypter().getAlphabet()));
		} else {
			VigenereCipher vigenere = new VigenereCipher();
			vigenere.setKeyword(encrypter.getKeyword());
			setRealCipher(vigenere);
		}
	}

	@Override
	public void buildJump() {
		getEncrypter().setJump(0);
	}

	@Override
	public void buildRails() {
		getEncrypter().setRails(0);
	}

	@Override
	public void buildKeyword() {
		try {
			getEncrypter().setKeyword(getParams()[1]);
		} catch ( IndexOutOfBoundsException e ) {
			getEncrypter().setKeyword(null);
		}
	}

	@Override
	public void buildAlphabet() {
		try {
			getEncrypter().setAlphabet(getParams()[2]);
		} catch ( IndexOutOfBoundsException e ) {
			getEncrypter().setAlphabet(null);
		}
	}

}
