package ar.edu.unlp.info.oo2.cypher;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	public void textWithSpacesEncryptedTest() {
		assertEquals("hpnd qztkw", vigenere.cipher("hola mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionTest() {
		assertEquals("hpnd@qztkw", vigenere.cipher("hola@mundo"));
	}
	
	@Test
	public void simpleTextDecryptionTest() {
		assertEquals("holamundo", vigenere.decipher("hpndqztkw"));
	}
	
	@Test
	public void textWithSpacesDecryptedTest() {
		assertEquals("hola mundo", vigenere.decipher("hpnd qztkw"));
	}
	
	@Test
	public void textWithSpecialCharacterDecryptedTest() {
		assertEquals("hola@mundo", vigenere.decipher("hpnd@qztkw"));
	}
}
