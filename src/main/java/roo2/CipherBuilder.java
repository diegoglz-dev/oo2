package roo2;

/*
 * Builder interface
 */
public interface CipherBuilder {
	
	public abstract int buildJump();
	public abstract int buildRails();
	public abstract String buildKeyword();
	public abstract String buildAlphabet();
}
