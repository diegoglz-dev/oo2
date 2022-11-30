package roo2;
/*
 * Concrete Builder
 */
public class CesarCipherBuilder extends CipherBuilder {
	
	public CesarCipherBuilder(String[] params) {
		setEncrypter(new Encrypter());
		setParams(params);
		initializeCipher();
	}

	@Override
	public void buildJump() {
		getEncrypter().setJump(Integer.parseInt(getParams()[1]));
	}

	@Override
	public void buildRails() {
		getEncrypter().setRails(0);
	}

	@Override
	public void buildKeyword() {
		getEncrypter().setKeyword(null);
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
		buildAlphabet();
		if (getEncrypter().getAlphabet() != null) {
			setRealCipher(new CesarCipher(getEncrypter().getJump(), getEncrypter().getAlphabet()));
		} else {
			setRealCipher(new CesarCipher(getEncrypter().getJump()));
		}
	}

}
