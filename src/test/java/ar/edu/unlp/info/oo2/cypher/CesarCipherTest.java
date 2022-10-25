package ar.edu.unlp.info.oo2.cypher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import roo2.CesarCipher;

public class CesarCipherTest {
	CesarCipher cesar_s0;
	CesarCipher cesar_s3;
	CesarCipher cesar_s26;
	CesarCipher cesar_smenos1;
	
	@BeforeEach
	void setUp() {
		cesar_s0 = new CesarCipher(0);
		cesar_s3 = new CesarCipher(3);
		cesar_s26 = new CesarCipher(26);
		cesar_smenos1 = new CesarCipher(-1);
	}
	
	@Test
	public void simpleTextEncryptedTest() {
		assertEquals("krodpxqgr", cesar_s3.cipher("holamundo"));
	}
	
	@Test
	public void simpleTextDecryptionTest() {
		assertEquals("holamundo", cesar_s3.decipher("krodpxqgr"));
	}
	
	@Test
	public void textWithSpacesEncryptedTest() {
		assertEquals("krod pxqgr", cesar_s3.cipher("hola mundo"));
	}
	
	@Test
	public void textWithSpacesDecryptedTest() {
		assertEquals("hola mundo", cesar_s3.decipher("krod pxqgr"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionTest() {
		assertEquals("krod@pxqgr", cesar_s3.cipher("hola@mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterDecryptedTest() {
		assertEquals("hola@mundo", cesar_s3.decipher("krod@pxqgr"));
	}
	
	@Test
	public void lastCharactersEncryptedTest() {
		assertEquals("pdalplcr", cesar_s3.cipher("maximizo"));
	}
	
	@Test
	public void lastCharactersDecrypted() {
		assertEquals("maximizo", cesar_s3.decipher("pdalplcr"));
	}
	
	@Test
	public void simpleTestWithCeroJumpEncryptedTest() {
		assertEquals("holamundo", cesar_s0.cipher("holamundo"));
	}
	
	@Test
	public void simpleTestWithCeroJumpDecrypted() {
		assertEquals("holamundo", cesar_s0.decipher("holamundo"));
	}
	
	@Test
	public void textWithSpacesWithCeroJumpEncryptedTest() {
		assertEquals("hola mundo", cesar_s0.cipher("hola mundo"));
	}
	
	@Test
	public void textWithSpacesWithCeroJumpDecryptedTest() {
		assertEquals("hola mundo", cesar_s0.decipher("hola mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterWithCeroJumpEncryptionTest() {
		assertEquals("hola@mundo", cesar_s0.cipher("hola@mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterWithCeroJumpDecryptedTest() {
		assertEquals("hola@mundo", cesar_s0.decipher("hola@mundo"));
	}
	
	@Test
	public void emptyTextEncryptionTest() {
		assertEquals(" ", cesar_s3.cipher(" "));
	}
	
	@Test
	public void emptyTestDecryptedTest() {
		assertEquals(" ", cesar_s3.decipher(" "));
	}
	
	@Test
	public void characterÑEncryption() {
		assertEquals("ñ", cesar_s3.cipher("ñ"));
	}
	
	@Test
	public void characterÑDecryption() {
		assertEquals("ñ", cesar_s3.decipher("ñ"));
	}
	
	@Test
	public void simpleTextWith26JumpEncryptionTest() {
		assertEquals("holamundo", cesar_s26.cipher("holamundo"));
	}
	
	@Test
	public void simpleTextWith26JumpDecryptedTest() {
		assertEquals("holamundo", cesar_s26.decipher("holamundo"));
	}
	
	/*@Test
	public void simpleTextWithNegativeJumpEncryptionTest() {
		assertEquals("hola", cesar_smenos1.cipher("gnkz"));
	}*/
	
	@Test
	public void numbersWithCeroJumpEncryptionTest() {
		assertEquals("123", cesar_s3.cipher("123"));
	}
	
	@Test
	public void numbersWithCeroJumpDecryptedTest() {
		assertEquals("123", cesar_s3.decipher("123"));
	}
}
