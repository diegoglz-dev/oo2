package roo2;

/*
 * Concrete Builder
 */
public class ConcreteCipherBuilder implements CipherBuilder {
	protected String[] params;
	
	public ConcreteCipherBuilder(String[] params) {
		setParams(params);
	}
	
	public void setParams(String[] params) {
		this.params = params;
	}
	
	public String[] getParams() {
		return params;
	}
	
	@Override
	public int buildJump() {
		try {
			return Integer.parseInt(getParams()[1]);
		} catch ( NumberFormatException e ) {
			return 0;
		}
	}

	@Override
	public int buildRails() {
		try {
			return Integer.parseInt(getParams()[1]);
		} catch ( NumberFormatException e ) {
			return 0;
		}
	}

	@Override
	public String buildKeyword() {
		try {
			return getParams()[1];
		} catch ( IndexOutOfBoundsException e ) {
			return null;
		}
	}

	@Override
	public String buildAlphabet() {
		try {
			return getParams()[2];
		} catch ( IndexOutOfBoundsException e ) {
			return null;
		}
	}

	public Cipher builCesarCipher() {
		if (buildAlphabet() != null) {
			return new CesarCipher(buildJump(), buildAlphabet());
		} else {
			return new CesarCipher(buildJump());
		}
	}
	
	public Cipher buildRailFenceCipher() {
		return new RailFenceCipher(buildRails());
	}
	
	public Cipher buildVigenereCipher() {
		if (buildAlphabet() != null) {
			return new VigenereCipher(buildKeyword(), buildAlphabet());
		} else {
			VigenereCipher vigenere = new VigenereCipher();
			vigenere.setKeyword(buildKeyword());
			return vigenere;
		}
	}
	
	public Cipher buildTranspositionCipher() {
		return new TranspositionCipher(buildKeyword());
	}

	public Cipher buildComplexCipher() {
		return new ComplexCipher();
	}
}
