package br.com.itau.integrador.validation;

import java.util.regex.Pattern;

public class ValidaCep {
	
	public static boolean validarCEP(String cep) {
		if (cep == "") {
			return false;
		}
		return Pattern.compile("[0-9]{8}").matcher(cep).matches();
	}
}
