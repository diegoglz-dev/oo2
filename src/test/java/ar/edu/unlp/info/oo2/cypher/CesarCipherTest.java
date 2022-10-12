package ar.edu.unlp.info.oo2.cypher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import roo2.CesarCipher;

public class CesarCipherTest {
	CesarCipher cesar;
	
	@BeforeEach
	void setUp() {
		cesar = new CesarCipher(3);
	}
	
	@Test
	public void simpleTextEncryptedTest() {
		assertEquals("krodpxqgr", cesar.cipher("holamundo"));
	}
	
	@Test
	public void simpleTextEncryptedWrongTest() {
		assertNotEquals("krodpxqgq", cesar.cipher("holamundo"));
	}
	
	@Test
	public void textWithSpacesEncryptedTest() {
		assertEquals("krod pxqgr", cesar.cipher("hola mundo"));
	}
	
	@Test
	public void textWithSpacesEncryptionWrongTest() {
		assertNotEquals("krod pxqgq", cesar.cipher("hola mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionTest() {
		assertEquals("krod@pxqgr", cesar.cipher("hola@mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionWrongTest() {
		assertNotEquals("krodpxqgr@", cesar.cipher("hola@mundo"));
	}
	
	@Test
	public void simpleTextDecryptionTest() {
		assertEquals("holamundo", cesar.decipher("krodpxqgr"));
	}
	
	@Test
	public void textSimpleDecryptedWrongTest() {
		assertNotEquals("holamundo", cesar.decipher("krodpxqgw"));
	}
	
	@Test
	public void textWithSpacesDecryptedTest() {
		assertEquals("hola mundo", cesar.decipher("krod pxqgr"));
	}
	
	@Test
	public void textWithSpacesDecryptionWrongTest() {
		assertNotEquals("hola mundo", cesar.decipher("kroa pxqgq"));
	}
	
	@Test
	public void textWithSpecialCharacterDecryptedTest() {
		assertEquals("hola@mundo", cesar.decipher("krod@pxqgr"));
	}
	
	@Test
	public void textWithSpecialCharacterDecryptionWrongTest() {
		assertNotEquals("hola@mundo", cesar.decipher("kroa@pxqgq"));
	}
}
