package ar.edu.unlp.info.oo2.cypher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import roo2.RailFenceCipher;

public class RailFenceCipherTest {
	RailFenceCipher railFence3;
	RailFenceCipher railFence5;
	
	@BeforeEach
	void setUp() {
		railFence3 = new RailFenceCipher(3);
		railFence5 = new RailFenceCipher(5);
	}
	
	@Test
	public void simpleTextEncryptedTest() {
		assertEquals("qtwrye", railFence3.cipher("qwerty"));
		assertEquals("qweryt", railFence5.cipher("qwerty"));
	}
	
	@Test
	public void textWithSpacesEncryptedTest() {
		assertEquals("h otoacm saloes", railFence3.cipher("hola como estas"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionTest() {
		assertEquals("h@otoacm@saloes", railFence3.cipher("hola@como@estas"));
	}
	
	@Test
	public void simpleTextEncryptionTest() {
		assertEquals("qwerty", railFence3.decipher("qtwrye"));
	}
	
	@Test
	public void textWithSpacesDecryptedTest() {
		assertEquals("hola como estas", railFence3.decipher("h otoacm saloes"));
	}
	
	@Test
	public void textWithSpacesDecryptedTest2() {
		assertEquals("qwerty", railFence3.decode("qtwrye",3));
	}
	
	@Test
	public void textWithSpecialCharacterDecryptedTest() {
		assertEquals("hola@como@estas", railFence3.decipher("h@otoacm@saloes"));
	}
}
