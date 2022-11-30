package roo2;
/*
 * Product class
 */
public class Encrypter {
	private int jump = 0;
	private int rails = 0;
	private String keyword = "";
	private String alphabet = "";

	public void setJump(int jump) {
		this.jump = jump;
	}
	
	public int getJump() {
		return jump;
	}

	public void setRails(int rails) {
		this.rails = rails;
	}
	
	public int getRails() {
		return rails;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}
	
	public String getAlphabet() {
		return alphabet;
	}
}
