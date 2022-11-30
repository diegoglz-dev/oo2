package ar.edu.unlp.info.oo2.cypher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import roo2.CreatorCipher;

public class VigenerCipherTest {
	CreatorCipher vigenere;
	
	@BeforeEach
	void setUp() {
		vigenere = new CreatorCipher("VigenereCipher,abcdefghijklmnopqrstuvwxyz");
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
	
	@Test
	public void emptyTextEncryptionTest() {
		assertEquals(" ", vigenere.cipher(" "));
	}
	
	@Test
	public void emptyTestDecryptedTest() {
		assertEquals(" ", vigenere.decipher(" "));
	}
	
	@Test
	public void characterÑEncryption() {
		assertEquals("ñ", vigenere.cipher("ñ"));
	}
	
	@Test
	public void characterÑDecryption() {
		assertEquals("ñ", vigenere.decipher("ñ"));
	}
	
	@Test
	public void numbersWithCeroJumpEncryptionTest() {
		assertEquals("123", vigenere.cipher("123"));
	}
	
	@Test
	public void numbersWithCeroJumpDecryptedTest() {
		assertEquals("123", vigenere.decipher("123"));
	}
}
