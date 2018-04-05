package br.com.calculator.MVC;

import org.junit.jupiter.api.Test;

class TesteView {

	@Test
	void testSimples() {
		View visualizaçao = new View();
		
		System.out.println(visualizaçao.operacao("2.4", "1.3", '+'));
		System.out.println(visualizaçao.operacao("2.4", "1.3", '-'));
		System.out.println(visualizaçao.operacao("2.4", "1.3", '*'));
		System.out.println(visualizaçao.operacao("2", "6.3", '/'));
		System.out.println(visualizaçao.operacao("2", "0", '/'));
	
	}
	
	@Test
	void testOperador() {
		View view = new View();
		
		System.out.println(view.view("1"));
		System.out.println(view.view("2"));
		System.out.println(view.view("3"));
		System.out.println(view.view("4"));
		System.out.println(view.view("5"));
		
		view.testOperador('+');
		
		System.out.println(view.view("1"));
		System.out.println(view.view("2"));
		System.out.println(view.view("3"));
		System.out.println(view.view("4"));
		System.out.println(view.view("5"));
		System.out.println(view.operacao());
		
		view.testOperador('+');
		
		System.out.println(view.view("1"));
		System.out.println(view.view("2"));
		System.out.println(view.view("3"));
		System.out.println(view.view("4"));
		System.out.println(view.pontoDecimal());
		System.out.println(view.view("5"));
		System.out.println(view.pontoDecimal());
		System.out.println(view.pontoDecimal());
		System.out.println(view.view("5"));
		
		System.out.println(view.operacao());
		
	}

}
