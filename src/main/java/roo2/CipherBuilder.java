package roo2;

/*
 * Abstract Builder
 */
public abstract class CipherBuilder {
	protected String[] params;
	
	public void setParams(String[] params) {
		this.params = params;
	}
	
	public String[] getParams() {
		return params;
	}
	
	public abstract int buildJump();
	public abstract int buildRails();
	public abstract String buildKeyword();
	public abstract String buildAlphabet();
	
	public abstract Cipher builCesarCipher();
	public abstract Cipher buildRailFenceCipher();
	public abstract Cipher buildVigenereCipher();
	public abstract Cipher buildTranspositionCipher();
	public abstract Cipher buildComplexCipher();
}
