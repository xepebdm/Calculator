package br.com.calculator.operacao;

import org.hamcrest.core.StringContains;

public class Operacao {

	// DECLARACAO DE VARIAVEIS
	private double num1, num2; // VALORES PARA OPERACAO

	private char operador; // OPERADOR MATEMATICO

	private String text1 = ""; // PRIMEIRO VALOR EM STRING PARA EXIBICAO
	private String text2 = ""; // SEGUNDO VALOR EM STRING PARA EXIBICAO

	private boolean testText; // SE TRUE, PASSA A ATRIBUIR VALOR NO TEXT2
	private boolean testOperator; // SE TRUE, OPERADOR J� EST� DEFINIDO
	// private boolean testPonto = false; //SE TRUE, J� EXISTE PONTO DECIMAL NAS
	// VARIAVEIS

	/*
	 * @param realizar opera��es pelo bot�o igual (=)
	 * 
	 * @version 1.0
	 * 
	 * @author Alexsandre
	 */
	// BOTAO IGUAL =
	public String oper() {

		this.testText = false;
		if (this.operador == '+') {
			num2 = Double.valueOf(text2);
			text1 = String.valueOf(num1 + num2);
			text2 = "";
			return String.valueOf(num1 + num2);
		} else if (this.operador == '-') {
			num2 = Double.valueOf(text2);
			text1 = String.valueOf(num1 - num2);
			text2 = "";
			return String.valueOf(num1 - num2);
		} else if (this.operador == '*') {
			num2 = Double.valueOf(text2);
			text1 = String.valueOf(num1 * num2);
			text2 = "";
			return String.valueOf(num1 * num2);
		} else if (this.operador == '/') {
			num2 = Double.valueOf(text2);
			text1 = String.valueOf(num2 == 0 ? 0 : num1 / num2);
			text2 = "";
			return String.valueOf(num2 == 0 ? error() : num1 / num2);
		} else {
			return "Teste opera��o falso";
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
			testText = true;
			testOperator = true;
			num1 = Double.valueOf(text1);
			//text1 = String.valueOf(num1);
			this.operador = operador;
			return text1 + operador;
		} else { // COM OPERADOR J� DEFINIDO
			this.testOperator = false;
			this.operador = operador;
			return oper() + operador;
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
		if (testText) { // TEXTFIELD COM OPERADOR JA DEFINIDO
			text1 = "";
			text2 += valor;
			return String.valueOf(num1) + this.operador + text2;
		} else { // TEXTFIELD COM OPERADOR N�O DEFINIDO
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

		if (!testText) {
			if (text1.contains(".")) {
				return definir("");
			} else {
				return definir(".");
			}
		} else if (text2.equals("")) {
			return definir("");
		} else {
			if (text2.contains(".")) {
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
		// RESTAURAR TODAS AS VARIAVEIS PARA VALOR PADR�O E RETORNA MSG DE ERRO
		this.text1 = "";
		this.text2 = "";
		this.num1 = 0;
		this.num2 = 0;
		this.testOperator = false;
		this.testText = false;

		return "N�o � poss�vel dividir por 0!";
	}
}
