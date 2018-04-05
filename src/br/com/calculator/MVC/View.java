package br.com.calculator.MVC;

public class View extends Modelo {

	String text1 = "";
	String text2 = "";
	char operador;

	public String view(String valor) {
		if (testOperador) { // TEXTFIELD COM OPERADOR JA DEFINIDO
			text2 += valor;
			return text1 + Character.toString(this.operador) + text2;

		} else { // TEXTFIELD COM OPERADOR NÃO DEFINIDO
			text2 = "";
			return text1 += valor;
		}
	}

	public String operacao() {
		if(text2.equals("")) {
			text1="";
			return "";
		}
		text1 = super.operacao(text1, text2, operador);
		text2 = "";
		return text1;

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

		if (!testOperador) { // NENHUM OPERADOR DEFINIDO
			if (text1.equals("")) { // SEM DIGITOS NO TEXTFIELD
				return "Teste operador sem digitos";
			}
			this.testOperador = true;
			this.operador = operador;
			return text1 + operador;
		} else { // COM OPERADOR JÁ DEFINIDO
			text1 = this.operacao();
			this.operador = operador;
			return text1 + operador;
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

		if (!testOperador) {
			if (text1.contains(".") || text1.contains(",")) {
				return view("");
			} else {
				return view(".");
			}
		} else if (text2.equals("")) {
			return view("");
		} else {
			if (text2.contains(".") || text1.contains(",")) {
				return view("");

			} else {
				return view(".");

			}
		}

	}
}
