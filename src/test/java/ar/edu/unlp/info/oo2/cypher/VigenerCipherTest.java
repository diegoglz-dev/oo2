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
		assertEquals("hpndqztkw", vigenere.encryptMessage("holamundo"));
	}
	
	@Test
	public void textWithSpacesEncryptedTest() {
		assertEquals("hpnd qztkw", vigenere.encryptMessage("hola mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionTest() {
		assertEquals("hpnd@qztkw", vigenere.encryptMessage("hola@mundo"));
	}
	
	@Test
	public void simpleTextDecryptionTest() {
		assertEquals("holamundo", vigenere.decryptMessage("hpndqztkw"));
	}
	
	@Test
	public void textWithSpacesDecryptedTest() {
		assertEquals("hola mundo", vigenere.decryptMessage("hpnd qztkw"));
	}
	
	@Test
	public void textWithSpecialCharacterDecryptedTest() {
		assertEquals("hola@mundo", vigenere.decryptMessage("hpnd@qztkw"));
	}
	
	@Test
	public void emptyTextEncryptionTest() {
		assertEquals(" ", vigenere.encryptMessage(" "));
	}
	
	@Test
	public void emptyTestDecryptedTest() {
		assertEquals(" ", vigenere.decryptMessage(" "));
	}
	
	@Test
	public void characterÑEncryption() {
		assertEquals("ñ", vigenere.encryptMessage("ñ"));
	}
	
	@Test
	public void characterÑDecryption() {
		assertEquals("ñ", vigenere.decryptMessage("ñ"));
	}
	
	@Test
	public void numbersWithCeroJumpEncryptionTest() {
		assertEquals("123", vigenere.encryptMessage("123"));
	}
	
	@Test
	public void numbersWithCeroJumpDecryptedTest() {
		assertEquals("123", vigenere.decryptMessage("123"));
	}
}
