package ar.edu.unlp.info.oo2.cypher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import roo2.CreatorCipher;

public class CesarCipherTest {
	CreatorCipher cesar_s0;
	CreatorCipher cesar_s3;
	CreatorCipher cesar_s26;
	
	@BeforeEach
	void setUp() {
		cesar_s0 = new CreatorCipher("CesarCipher,0");
		cesar_s3 = new CreatorCipher("CesarCipher,3");
		cesar_s26 = new CreatorCipher("CesarCipher,26");
	}
	
	@Test
	public void simpleTextEncryptedTest() {
		assertEquals("krodpxqgr", cesar_s3.encryptMessage("holamundo"));
	}
	 
	@Test
	public void simpleTextDecryptionTest() {
		assertEquals("holamundo", cesar_s3.decryptMessage("krodpxqgr"));
	}
	
	@Test
	public void textWithSpacesEncryptedTest() {
		assertEquals("krod pxqgr", cesar_s3.encryptMessage("hola mundo"));
	}
	
	@Test
	public void textWithSpacesDecryptedTest() {
		assertEquals("hola mundo", cesar_s3.decryptMessage("krod pxqgr"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionTest() {
		assertEquals("krod@pxqgr", cesar_s3.encryptMessage("hola@mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterDecryptedTest() {
		assertEquals("hola@mundo", cesar_s3.decryptMessage("krod@pxqgr"));
	}
	
	@Test
	public void lastCharactersEncryptedTest() {
		assertEquals("pdalplcr", cesar_s3.encryptMessage("maximizo"));
	}
	
	@Test
	public void lastCharactersDecrypted() {
		assertEquals("maximizo", cesar_s3.decryptMessage("pdalplcr"));
	}
	
	@Test
	public void simpleTestWithCeroJumpEncryptedTest() {
		assertEquals("holamundo", cesar_s0.encryptMessage("holamundo"));
	}
	
	@Test
	public void simpleTestWithCeroJumpDecrypted() {
		assertEquals("holamundo", cesar_s0.decryptMessage("holamundo"));
	}
	
	@Test
	public void textWithSpacesWithCeroJumpEncryptedTest() {
		assertEquals("hola mundo", cesar_s0.encryptMessage("hola mundo"));
	}
	
	@Test
	public void textWithSpacesWithCeroJumpDecryptedTest() {
		assertEquals("hola mundo", cesar_s0.decryptMessage("hola mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterWithCeroJumpEncryptionTest() {
		assertEquals("hola@mundo", cesar_s0.encryptMessage("hola@mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterWithCeroJumpDecryptedTest() {
		assertEquals("hola@mundo", cesar_s0.decryptMessage("hola@mundo"));
	}
	
	@Test
	public void emptyTextEncryptionTest() {
		assertEquals(" ", cesar_s3.encryptMessage(" "));
	}
	
	@Test
	public void emptyTestDecryptedTest() {
		assertEquals(" ", cesar_s3.decryptMessage(" "));
	}
	
	@Test
	public void characterÑEncryption() {
		assertEquals("ñ", cesar_s3.encryptMessage("ñ"));
	}
	
	@Test
	public void characterÑDecryption() {
		assertEquals("ñ", cesar_s3.decryptMessage("ñ"));
	}
	
	@Test
	public void simpleTextWith26JumpEncryptionTest() {
		assertEquals("holamundo", cesar_s26.encryptMessage("holamundo"));
	}
	
	@Test
	public void simpleTextWith26JumpDecryptedTest() {
		assertEquals("holamundo", cesar_s26.decryptMessage("holamundo"));
	}
	
	@Test
	public void numbersWithCeroJumpEncryptionTest() {
		assertEquals("123", cesar_s3.encryptMessage("123"));
	}
	
	@Test
	public void numbersWithCeroJumpDecryptedTest() {
		assertEquals("123", cesar_s3.decryptMessage("123"));
	}
}
