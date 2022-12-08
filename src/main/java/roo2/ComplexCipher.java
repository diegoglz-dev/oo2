package roo2;

import java.util.ArrayList;
import java.util.List;

public class ComplexCipher implements Cipher {
	private List<Cipher> ciphers;
	
	public ComplexCipher() {
		setCiphers(new ArrayList<Cipher>());
	}
	
	public ComplexCipher(List<Cipher> ciphers) {
		setCiphers(ciphers);
	}
	
	public void addCipher(Cipher cipher) {
		this.getCiphers().add(cipher);
	}

	@Override
	public String cipher(String inputText) {
		String result = inputText;
		for (int i = 0; i < getCiphers().size(); i++) {
			if (!getCiphers().get(i).getClass().getName().equals("roo2.ComplexCipher"))
				result = getCiphers().get(i).cipher(result);
		}
		return result;
	}

	@Override
	public String decipher(String inputText) {
		String result = inputText;
		for (int i = getCiphers().size() - 1; i >= 0; --i) {
			if (!getCiphers().get(i).getClass().getName().equals("roo2.ComplexCipher"))
				result = getCiphers().get(i).decipher(result);
		}
		return result;
	}

	public List<Cipher> getCiphers() {
		return ciphers;
	}

	public void setCiphers(List<Cipher> ciphers) {
		this.ciphers = ciphers;
	}

}
