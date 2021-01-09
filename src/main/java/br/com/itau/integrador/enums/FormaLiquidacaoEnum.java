package br.com.itau.integrador.enums;

public enum FormaLiquidacaoEnum {
	REFIN("Refin",1),
	PORTABILIDADE_ATAQUE_OUTRO_BANCO("PortabilidadeAtaque",2),
	REFINANCIAMENTO_CARTEIRA("RefinanciamentoCarteira",3);
	
	
	private int id;
	private String chave;

	FormaLiquidacaoEnum(String chave, int id) {
		this.id = id;
		this.chave = chave;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
	

}
