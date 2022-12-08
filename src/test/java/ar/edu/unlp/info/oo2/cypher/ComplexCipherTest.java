package ar.edu.unlp.info.oo2.cypher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import roo2.CreatorCipher;

public class ComplexCipherTest {
	CreatorCipher complex;
	
	@BeforeEach
	void setUp() {
		complex = new CreatorCipher("ComplexCipher");
		complex.addCipher(new CreatorCipher("CesarCipher,3").getCipher());
		complex.addCipher(new CreatorCipher("RailFenceCipher,3").getCipher());
	}
	
	@Test
	public void simpleTextEncryptedWithCesarAndRailFenceTest() {
		assertEquals("twzubh", complex.encryptMessage("qwerty"));
	}
	
	@Test
	public void simpleTextDecryptionWithCesarAndRailFenceTest() {
		assertEquals("qwerty", complex.decryptMessage("twzubh"));
	}
	
	@Test
	public void textWithSpacesEncryptedWithCesarAndRailFenceTest() {
		assertEquals("k grdpqrox", complex.encryptMessage("hola mundo"));
	}
	
	@Test
	public void textWithSpacesDecryptionWithCesarAndRailFenceTest() {
		assertEquals("hola mundo", complex.decryptMessage("k grdpqrox"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptedWithCesarAndRailFenceTest() {
		assertEquals("k@grdpqrox", complex.encryptMessage("hola@mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterDecryptionWithCesarAndRailFenceTest() {
		assertEquals("hola@mundo", complex.decryptMessage("k@grdpqrox"));
	}
}
