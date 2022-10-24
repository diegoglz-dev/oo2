package ar.edu.unlp.info.oo2.cypher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import roo2.RailFenceCipher;

public class RailFenceCipherTest {
	RailFenceCipher railFence;
	
	@BeforeEach
	void setUp() {
		railFence = new RailFenceCipher(3);
	}
	
	@Test
	public void simpleTextEncryptedTest() {
		assertEquals("qtwrye", railFence.cipher("qwerty"));
	}
	
	@Test
	public void textWithSpacesEncryptedTest() {
		assertEquals("h otoacm saloes", railFence.cipher("hola como estas"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionTest() {
		assertEquals("h@otoacm@saloes", railFence.cipher("hola@como@estas"));
	}
	
	@Test
	public void simpleTextEncryptionTest() {
		assertEquals("qwerty", railFence.decipher("qtwrye"));
	}
	
	@Test
	public void textWithSpacesDecryptedTest() {
		assertEquals("hola como estas", railFence.decipher("h otoacm saloes"));
	}
	
	@Test
	public void textWithSpacesDecryptedTest2() {
		assertEquals("qwerty", railFence.decode("qtwrye",3));
	}
	
	@Test
	public void textWithSpecialCharacterDecryptedTest() {
		assertEquals("hola@como@estas", railFence.decipher("h@otoacm@saloes"));
	}
}
