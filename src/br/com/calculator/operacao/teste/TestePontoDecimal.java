package br.com.calculator.operacao.teste;

import br.com.calculator.operacao.Operacao;

public class TestePontoDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operacao operacao = new Operacao();
		long inicio =  System.currentTimeMillis();
		
		System.out.println(operacao.definir("1000"));
		System.out.println(operacao.pontoDecimal());
		//System.out.println(operacao.definir("."));
		System.out.println(operacao.definir("500"));
		System.out.println(operacao.pontoDecimal());
		System.out.println(operacao.testOperador('/'));
		System.out.println(operacao.pontoDecimal());
		//System.out.println(operacao.definir("."));
		System.out.println(operacao.definir("5.5"));
		System.out.println(operacao.pontoDecimal());
		//System.out.println(operacao.definir("."));
		
		
		System.out.println(operacao.oper());
		
		long fim = System.currentTimeMillis();
		double tempo = (fim - inicio) / 1000.0;
		System.out.println("Tempo = " + tempo);
	}

}
