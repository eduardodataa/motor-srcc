package br.com.itau.integrador.util;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public final class Util {

	public static boolean validarCEP(String cep) {
		if (cep == "") {
			return false;
		}
		return Pattern.compile("[0-9]{8}").matcher(cep).matches();
	}
	
	/**
	 * Compara somente o mês e o ano entre duas datas
	 * @param Data 1 e Data 2
	 * @return
	 */
	public static boolean compararMesAnoEntreDatas(Date data1, Date data2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(data1);
		cal2.setTime(data2);
		boolean mesmoMesAno = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
		              cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
		return mesmoMesAno;
	}

}
