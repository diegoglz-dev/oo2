package roo2;
/*
 * Concrete Builder
 */
public class ConcreteCipherBuilder extends CipherBuilder {
	
	public ConcreteCipherBuilder(String[] params) {
		setEncrypter(new Encrypter());
		setParams(params);
		initializeCipher();
	}

	@Override
	public void buildJump() {
		try {
			getEncrypter().setJump(Integer.parseInt(getParams()[1]));
		} catch ( NumberFormatException e ) {
			getEncrypter().setJump(0);
		}
		
	}

	@Override
	public void buildRails() {
		try {
			getEncrypter().setRails(Integer.parseInt(getParams()[1]));
		} catch ( NumberFormatException e ) {
			getEncrypter().setRails(0);
		}
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

	@Override
	public void initializeCipher() {
		buildJump();
		buildRails();
		buildKeyword();
		buildAlphabet();
	}
	
	public void buildRailFenceCipher() {
		setRealCipher(new RailFenceCipher(getEncrypter().getRails()));
	}
	
	public void buildCesarCipher() {
		if (getEncrypter().getAlphabet() != null) {
			setRealCipher(new CesarCipher(getEncrypter().getJump(), getEncrypter().getAlphabet()));
		} else {
			setRealCipher(new CesarCipher(getEncrypter().getJump()));
		}
	}
	
	public void buildVigenereCipher() {
		if (getEncrypter().getAlphabet() != null) {
			setRealCipher(new VigenereCipher(getEncrypter().getKeyword(), getEncrypter().getAlphabet()));
		} else {
			VigenereCipher vigenere = new VigenereCipher();
			vigenere.setKeyword(encrypter.getKeyword());
			setRealCipher(vigenere);
		}
	}

	public void buildTranspositionCipher() {
		setRealCipher(new TranspositionCipher(getEncrypter().getKeyword()));
	}
}
