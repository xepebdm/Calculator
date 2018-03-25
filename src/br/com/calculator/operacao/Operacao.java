package br.com.calculator.operacao;

import org.hamcrest.core.StringContains;

public class Operacao {

	// DECLARACAO DE VARIAVEIS
		private double num1, num2; //VALORES PARA OPERACAO
		
		private char operador; //OPERADOR MATEMATICO
		
		private String text1 = ""; //PRIMEIRO VALOR EM STRING PARA EXIBICAO
		private String text2 = ""; //SEGUNDO VALOR EM STRING PARA EXIBICAO
		private String erro = "Não é possível dividir por 0!"; //ERRO DIVISAO POR ZERO 0
		
		private boolean testText; //SE TRUE, PASSA A ATRIBUIR VALOR NO TEXT2
		private boolean testOperator; //SE TRUE, OPERADOR JÁ ESTÁ DEFINIDO
		private boolean testPonto = false; //SE TRUE, JÁ EXISTE PONTO DECIMAL NAS VARIAVEIS
		
		
		/*
		 * @param realizar operações pelo botão igual (=)
		 * @version 1.0
		 * @author Alexsandre
		 */
		// BOTAO IGUAL =
		public String oper() {
			this.testOperator = false;
			this.testText = false;
			if (this.operador == '+') {
				num2 = Double.valueOf(text2);
				return String.valueOf(num1 + num2);
			} else if (this.operador == '-') {
				num2 = Double.valueOf(text2);
				return String.valueOf(num1 - num2);
			} else if (this.operador == '*') {
				num2 = Double.valueOf(text2);
				return String.valueOf(num1 * num2);
			} else if (this.operador == '/') {
				num2 = Double.valueOf(text2);
				return String.valueOf(num2 == 0 ? error() : num1 / num2);
			} else {
				return "";
			}
		}

		
		/*
		 * @param adicionar operador e realizar operacao
		 * @version 1.0
		 * @author Alexsandre
		 */
		// TESTE DE OPERADOR
		public String testOperador(Character operador) {

			if (text1.equals("")) { // SEM DIGITOS NO TEXTFIELD
				return "";
			} else if (!testOperator) { // NENHUM OPERADOR DEFINIDO
				testText = true;
				testOperator = true;
				num1 = Double.valueOf(text1);
				this.operador = operador;
				return text1 + operador;
			}

			// COM OPERADOR JÁ DEFINIDO
			text1 = oper();
			this.operador = operador;
			return text1 + this.operador;
		}

		
		/*
		 * @param texto do textField
		 * @version 1.0
		 * @author Alexsandre
		 */
		// ATUALIZAR TEXTFIELD
		public String definir(String valor) {
			if (testText) { // TEXTFIELD COM OPERADOR JA DEFINIDO
				text1 = "";
				text2 += valor;
				return String.valueOf(num1) + this.operador + text2;
			} else { // TEXTFIELD COM OPERADOR NÃO DEFINIDO
				text2 = "";
				return text1 += valor;
			}
		}

		
		/*
		 * @param adicionar ponto decimal
		 * @version 1.0
		 * @author Alexsandre
		 */
		//PONTO DECIMAL
		public String pontoDecimal() {
			/*if(text1.equals("")) { //TEXTFIELD VAZIO
				return "";
			}else if(testPonto) { //VERIFICA SE JÁ EXISTE PONTO DECIMAL
				return definir("");
			}else {
				testPonto = true;
				return definir(".");
			}*/
			
			if(testPonto) {
				return "";
			}else if(text1.contains(".")) {
				return definir(".");
			}else if(text2.contains(".")){
				return "";
			}else {
				return definir(".");
			}
		}

		
		/*
		 * @param erro divisao por zero 0
		 * @version 1.0
		 * @author Alexsandre
		 */
		//METODO DE ERRO DIVISAO POR ZERO 0
		private String error() {
			//RESTAURAR TODAS AS VARIAVEIS PARA VALOR PADRÃO E RETORNA MSG DE ERRO
			this.text1 = "";
			this.text2 = "";
			this.num1 = 0;
			this.num2 = 0;
			this.testOperator = false;
			this.testText = false;
			this.testPonto = false;
			return this.erro;
		}
}
