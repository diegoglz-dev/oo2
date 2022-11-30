package roo2;
/*
 * Concrete Builder
 */
public class TranspositionCipherBuilder extends CipherBuilder {

	public TranspositionCipherBuilder(String[] params) {
		setEncrypter(new Encrypter());
		setParams(params);
		initializeCipher();
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
		getEncrypter().setKeyword(getParams()[1]);
	}

	@Override
	public void buildAlphabet() {
		getEncrypter().setAlphabet(null);
	}

	@Override
	public void initializeCipher() {
		buildKeyword();
		setRealCipher(new TranspositionCipher(getEncrypter().getKeyword()));
	}

}
