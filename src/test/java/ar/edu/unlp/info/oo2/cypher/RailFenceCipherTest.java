package ar.edu.unlp.info.oo2.cypher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import roo2.CreatorCipher;

public class RailFenceCipherTest {
	CreatorCipher railFence3;
	CreatorCipher railFence5;
	
	@BeforeEach
	void setUp() {
		railFence3 = new CreatorCipher("RailFenceCipher,3");
		railFence5 = new CreatorCipher("RailFenceCipher,5");
	}
	
	@Test
	public void simpleTextEncryptedTest() {
		assertEquals("qtwrye", railFence3.encryptMessage("qwerty"));
		assertEquals("qweryt", railFence5.encryptMessage("qwerty"));
	}
	
	@Test
	public void textWithSpacesEncryptedTest() {
		assertEquals("h otoacm saloes", railFence3.encryptMessage("hola como estas"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionTest() {
		assertEquals("h@otoacm@saloes", railFence3.encryptMessage("hola@como@estas"));
	}
	
	@Test
	public void simpleTextEncryptionTest() {
		assertEquals("qwerty", railFence3.decryptMessage("qtwrye"));
	}
	
	@Test
	public void textWithSpacesDecryptedTest() {
		assertEquals("hola como estas", railFence3.decryptMessage("h otoacm saloes"));
	}
	
	@Test
	public void textWithSpecialCharacterDecryptedTest() {
		assertEquals("hola@como@estas", railFence3.decryptMessage("h@otoacm@saloes"));
	}
}
