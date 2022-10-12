package ar.edu.unlp.info.oo2.cypher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import roo2.VigenereCipher;

public class VigenerCipherTest {
	VigenereCipher vigenere;
	
	@BeforeEach
	void setUp() {
		vigenere = new VigenereCipher();
		vigenere.setKeyword("abcdefghijklmnopqrstuvwxyz");
	}
	
	@Test
	public void simpleTextEncryptedTest() {
		assertEquals("hpndqztkw", vigenere.cipher("holamundo"));
	}
	
	@Test
	public void simpleTextEncryptedWrongTest() {
		assertNotEquals("hpndqztkq", vigenere.cipher("holamundo"));
	}
	
	@Test
	public void textWithSpacesEncryptedTest() {
		assertEquals("hpnd qztkw", vigenere.cipher("hola mundo"));
	}
	
	@Test
	public void textWithSpacesEncryptionWrongTest() {
		assertNotEquals("hpndqztkw", vigenere.cipher("hola mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionTest() {
		assertEquals("hpnd@qztkw", vigenere.cipher("hola@mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionWrongTest() {
		assertNotEquals("hpndqztk@", vigenere.cipher("hola@mundo"));
	}
	
	@Test
	public void simpleTextDecryptionTest() {
		assertEquals("holamundo", vigenere.decipher("hpndqztkw"));
	}
	
	@Test
	public void textSimpleDecryptedWrongTest() {
		assertNotEquals("holamundo", vigenere.decipher("hpndqztkq"));
	}
	
	@Test
	public void textWithSpacesDecryptedTest() {
		assertEquals("hola mundo", vigenere.decipher("hpnd qztkw"));
	}
	
	@Test
	public void textWithSpacesDecryptionWrongTest() {
		assertNotEquals("hola mundo", vigenere.decipher("hpnd qztkq"));
	}
	
	@Test
	public void textWithSpecialCharacterDecryptedTest() {
		assertEquals("hola@mundo", vigenere.decipher("hpnd@qztkw"));
	}
	
	@Test
	public void textWithSpecialCharacterDecryptionWrongTest() {
		assertNotEquals("hola@mundo", vigenere.decipher("hpnd@qztkq"));
	}
}
