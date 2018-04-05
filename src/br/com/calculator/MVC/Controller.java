package br.com.calculator.MVC;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Controller {
	
	boolean testOperador = false;
	DecimalFormat dx = new DecimalFormat("0.##");
	
	/*
	 * @param realizar operações pelo botão igual (=)
	 * 
	 * @version 1.0
	 * 
	 * @author Alexsandre
	 */
	// BOTAO IGUAL =
	@SuppressWarnings("unlikely-arg-type")
	public BigDecimal oper(BigDecimal num1, BigDecimal num2, Character operador) {
		this.testOperador = false;
		
		if (operador == '+') {
			return num1.add(num2);
		} else if (operador == '-') {
			return num1.subtract(num2);
		} else if (operador == '*') {
			return num1.multiply(num2);
		} else if (operador == '/') {
			return (num2.equals(0) ? error() : (num1.divide(num2, 0)));
		} else {
			return error();
		}
	}
	
	

	
	
	private BigDecimal error() {
		return BigDecimal.ZERO;
	}
}
