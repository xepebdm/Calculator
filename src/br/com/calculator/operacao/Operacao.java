package br.com.calculator.operacao;

import java.text.DecimalFormat;

public class Operacao {

	// DECLARACAO DE VARIAVEIS
	DecimalFormat dx = new DecimalFormat("0.#####");
	
	private char operador; // OPERADOR MATEMATICO

	private String text1 = ""; // PRIMEIRO VALOR EM STRING PARA EXIBICAO
	private String text2 = ""; // SEGUNDO VALOR EM STRING PARA EXIBICAO
	
	private double num1; //VALORES PARA OPERACAO
	private double num2; // VALORES PARA OPERACAO

	private boolean testOperator; // SE TRUE, OPERADOR JÁ ESTÁ DEFINIDO
	
	/*
	 * @param realizar operações pelo botão igual (=)
	 * 
	 * @version 1.0
	 * 
	 * @author Alexsandre
	 */
	// BOTAO IGUAL =
	public String oper() {
		this.testOperator = false;
		num2 = Double.valueOf(text2);
		if (this.operador == '+') {
			text1 = String.valueOf(dx.format(num1 + num2));
			text2 = "";
			return String.valueOf(dx.format(num1 + num2));
		} else if (this.operador == '-') {
			text1 = String.valueOf(dx.format(num1 - num2));
			text2 = "";
			return String.valueOf(dx.format(num1 - num2));
		} else if (this.operador == '*') {
			text1 = String.valueOf(dx.format(num1 * num2));
			text2 = "";
			return String.valueOf(dx.format(num1 * num2));
		} else if (this.operador == '/') {
			text1 = String.valueOf(dx.format(num2 == 0 ? 0 : num1 / num2));
			text2 = "";
			return String.valueOf(dx.format(num2 == 0 ? error() : num1 / num2));
		} else {
			return "Teste operação falso";
		}
	}

	/*
	 * @param adicionar operador e realizar operacao
	 * 
	 * @version 1.1
	 * 
	 * @author Alexsandre
	 */
	// TESTE DE OPERADOR
	public String testOperador(Character operador) {
		
		if (!testOperator) { // NENHUM OPERADOR DEFINIDO
			if (text1.equals("")) { // SEM DIGITOS NO TEXTFIELD
				return "Teste operador sem digitos";
			}
			this.testOperator = true;
			num1 = Double.valueOf(text1);
			text1 = String.valueOf(num1);
			this.operador = operador;
			return text1 + operador;
		} else { // COM OPERADOR JÁ DEFINIDO
			this.testOperator = false;
			text1 = oper();
			this.operador = operador;
			return text1 + operador;
		}
	}

	/*
	 * @param texto do textField
	 * 
	 * @version 1.1
	 * 
	 * @author Alexsandre
	 */
	// ATUALIZAR TEXTFIELD
	public String definir(String valor) {
		if (testOperator) { // TEXTFIELD COM OPERADOR JA DEFINIDO
			text1 = "";
			text1 = String.valueOf(num1);
			text2 += valor;
			return text1 + Character.toString(this.operador) + text2;
					
		} else { // TEXTFIELD COM OPERADOR NÃO DEFINIDO
			text2 = "";
			return text1 += valor;
		}
	}

	/*
	 * @param adicionar ponto decimal
	 * 
	 * @version 1.2
	 * 
	 * @author Alexsandre
	 */
	// PONTO DECIMAL
	public String pontoDecimal() {

		if (!testOperator) {
			if (text1.contains(".") || text1.contains(",")) {
				return definir("");
			} else {
				return definir(".");
			}
		} else if (text2.equals("")) {
			return definir("");
		} else {
			if (text2.contains(".") || text1.contains(",")) {
				return definir("");

			} else {
				return definir(".");

			}
		}

	}

	/*
	 * @param erro divisao por zero 0
	 * 
	 * @version 1.0
	 * 
	 * @author Alexsandre
	 */
	// METODO DE ERRO DIVISAO POR ZERO 0
	private String error() {
		// RESTAURAR TODAS AS VARIAVEIS PARA VALOR PADRÃO E RETORNA MSG DE ERRO
		this.text1 = "";
		this.text2 = "";
		this.num1 = 0;
		this.num2 = 0;
		this.testOperator = false;
		

		return "Não é possível dividir por 0!";
	}
}
