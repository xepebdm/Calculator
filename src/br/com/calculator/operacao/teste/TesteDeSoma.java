package br.com.calculator.operacao.teste;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;



class TesteDeSoma {

	@Test
	void testTestOperador() {
		assertEquals(100, 50+50);
	}
	
	@Test
	void testSubtrair() {
		assertEquals(10, 20-10);
	}
	

}
