package br.com.itau.integrador.enums;

public enum TipoOperacaoEnum {

	LIQUIDACAO_ANTECIPADA(2);

	TipoOperacaoEnum(int id) {
		this.id = id;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
