package roo2;

/*
 * Concrete Builder
 */
public class ConcreteCipherBuilder extends CipherBuilder {
	
	public ConcreteCipherBuilder(String[] params) {
		setParams(params);
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

	@Override
	public Cipher builCesarCipher() {
		if (buildAlphabet() != null) {
			return new CesarCipher(buildJump(), buildAlphabet());
		} else {
			return new CesarCipher(buildJump());
		}
	}
	
	@Override
	public Cipher buildRailFenceCipher() {
		return new RailFenceCipher(buildRails());
	}
	
	@Override
	public Cipher buildVigenereCipher() {
		if (buildAlphabet() != null) {
			return new VigenereCipher(buildKeyword(), buildAlphabet());
		} else {
			VigenereCipher vigenere = new VigenereCipher();
			vigenere.setKeyword(buildKeyword());
			return vigenere;
		}
	}
	
	@Override
	public Cipher buildTranspositionCipher() {
		return new TranspositionCipher(buildKeyword());
	}

	@Override
	public Cipher buildComplexCipher() {
		return new ComplexCipher();
	}
}
