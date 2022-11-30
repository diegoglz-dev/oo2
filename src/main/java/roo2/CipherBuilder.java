package roo2;
/*
 * Abstract Builder
 */
public abstract class CipherBuilder {
	protected Encrypter encrypter;
	protected String[] params;
	protected Cipher realCipher;

	public void setEncrypter(Encrypter encrypter) {
		this.encrypter = encrypter;
	}
	
	public Encrypter getEncrypter() {
		return encrypter;
	}
	
	public void setParams(String[] params) {
		this.params = params;
	}
	
	public String[] getParams() {
		return params;
	}
	
	public Cipher getRealCipher() {
		return realCipher;
	}

	public void setRealCipher(Cipher realCipher) {
		this.realCipher = realCipher;
	}
	
	public abstract void buildJump();
	public abstract void buildRails();
	public abstract void buildKeyword();
	public abstract void buildAlphabet();
	public abstract void initializeCipher();
}
