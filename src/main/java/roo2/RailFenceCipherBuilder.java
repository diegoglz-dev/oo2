package roo2;
/*
 * Concrete Builder
 */
public class RailFenceCipherBuilder extends CipherBuilder {

	public RailFenceCipherBuilder(String[] params) {
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
		getEncrypter().setRails(Integer.parseInt(getParams()[1]));
	}

	@Override
	public void buildKeyword() {
		getEncrypter().setKeyword(null);
	}

	@Override
	public void buildAlphabet() {
		getEncrypter().setAlphabet(null);
	}

	@Override
	public void initializeCipher() {
		buildRails();
		setRealCipher(new RailFenceCipher(getEncrypter().getRails()));
	}

}
