package br.com.calculator.MVC;

import java.math.BigDecimal;

public class Modelo extends Controller {
	BigDecimal valor1 = new BigDecimal(0);
	BigDecimal valor2 = new BigDecimal(0);
	BigDecimal resultado = new BigDecimal(0);

	public String operacao(String valor1, String valor2, char op) {
		if (Double.valueOf(valor2) <= 0) {
			return "Can't divide by zero.";
		} else {
			this.valor1 = BigDecimal.valueOf(Double.valueOf(valor1));
			this.valor2 = BigDecimal.valueOf(Double.valueOf(valor2));
			resultado = oper(this.valor1, this.valor2, Character.valueOf(op));
			return String.valueOf(resultado);

		}

	}

	
	
}
