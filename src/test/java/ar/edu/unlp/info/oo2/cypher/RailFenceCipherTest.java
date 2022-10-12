package ar.edu.unlp.info.oo2.cypher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import roo2.RailFenceCipher;

public class RailFenceCipherTest {
	RailFenceCipher railFence;
	
	@BeforeEach
	void setUp() {
		railFence = new RailFenceCipher(2);
	}
	
	@Test
	public void simpleTextEncryptedTest() {
		assertEquals("hlmnooaud", railFence.cipher("holamundo"));
	}
	
	@Test
	public void simpleTextEncryptedWrongTest() {
		assertNotEquals("hlmnooauq", railFence.cipher("holamundo"));
	}
	
	@Test
	public void textWithSpacesEncryptedTest() {
		assertEquals("hl udoamno", railFence.cipher("hola mundo"));
	}
	
	@Test
	public void textWithSpacesEncryptionWrongTest() {
		assertNotEquals("hl udoamni", railFence.cipher("hola mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionTest() {
		assertEquals("hl@udoamno", railFence.cipher("hola@mundo"));
	}
	
	@Test
	public void textWithSpecialCharacterEncryptionWrongTest() {
		assertNotEquals("hludoamno@", railFence.cipher("hola@mundo"));
	}
}
