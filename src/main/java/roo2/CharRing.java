package roo2;

public class  CharRing {
	char[] source;
	int index;
    
	public CharRing(String srcString) {
		source = new char[srcString.length()];
		srcString.getChars(0,srcString.length(), source, 0);
		index = 0;
	};

	public char next() {
		if(index >= source.length)
			index = 0;
		return source[index++];
	};
}