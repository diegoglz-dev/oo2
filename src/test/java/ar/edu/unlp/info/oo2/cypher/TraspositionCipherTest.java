package ar.edu.unlp.info.oo2.cypher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import roo2.CreatorCipher;

public class TraspositionCipherTest {
	CreatorCipher transposition;
	
	@BeforeEach
	void setUp() {
		transposition = new CreatorCipher("TranspositionCipher,hola");
	}
	
	@Test
	public void simpleTextEncryptedTest() {
		assertEquals("rqew t y                ", transposition.cipher("qwerty"));
	}
	
	@Test
	public void textWithSpacesEncryptedTest() {
		assertEquals("ahlon um d o                            ", transposition.cipher("hola mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionTest() {
		assertEquals("ahlon@um d o                            ", transposition.cipher("hola@mundo"));
	}
	
	@Test
	public void simpleTextDecryptionTest() {
		assertEquals("qwerty                          ", transposition.decipher("rqew t y                "));
	}
	
	@Test
	public void textWithSpacesDecryptedTest() {
		assertEquals("hola mundo", transposition.decipher("ahlon um d o                            "));
	}
	
	@Test
	public void textWithSpecialCharacterDecryptedTest() {
		assertEquals("hola@mundo", transposition.decipher("ahlon@um d o"));
	}
}
