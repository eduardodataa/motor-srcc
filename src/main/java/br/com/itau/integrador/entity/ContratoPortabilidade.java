package br.com.itau.integrador.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author joedsan
 *
 */
@Table
@Entity(name = "contrato_portabilidade")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoPortabilidade {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;  
	
	@Column
	private String identificacaoParticipanteAdministrado;
	private String CNPJEmpregador;
	private String cliente;
	private String cpf;
	
	/**
	 * Domínio
	 * 1 - INSS
	 * 2 - Outros
	 */
	private int tipoEmpregador;
	private int beneficioINSS;
	private int matricula;
	private int numeroContrato;
	private int tipoOperacao;
	
	/**
	 * Domínio
	 * Permitido somente '1' - Boleto para a 5982
	 */
	private int tipoLiquidacao;
	/**
	 * Pode ser:
	 * 	1 - Data da Liquidacao Antecipada
	 *  2 - Data da Quitação
	 */
	private Date dataLiquidacaoAntecipada_Quitacao;
	private Date dataUltimoVencimentoDaUltimaParcelaContrato; 
	private int formaLiquidacao;
	private String origemBaixa;
	
	//dados pós retorno CIP
	private String statusRetornoCIP;
	
	//bloco com todas as informações CIP no formato Json
	private String retornoJsonCIP;
	
	
	
	
	public ContratoPortabilidade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ContratoPortabilidade(String identificacaoParticipanteAdministrado, String cliente, String cpf,
			int tipoEmpregador, int beneficioINSS, int matricula, int numeroContrato, int tipoOperacao,
			int tipoLiquidacao, Date dataLiquidacaoAntecipada_Quitacao,
			Date dataUltimoVencimentoDaUltimaParcelaContrato, int formaLiquidacao, String origemBaixa) {
		super();
		this.identificacaoParticipanteAdministrado = identificacaoParticipanteAdministrado;
		this.cliente = cliente;
		this.cpf = cpf;
		this.tipoEmpregador = tipoEmpregador;
		this.beneficioINSS = beneficioINSS;
		this.matricula = matricula;
		this.numeroContrato = numeroContrato;
		this.tipoOperacao = tipoOperacao;
		this.tipoLiquidacao = tipoLiquidacao;
		this.dataLiquidacaoAntecipada_Quitacao = dataLiquidacaoAntecipada_Quitacao;
		this.dataUltimoVencimentoDaUltimaParcelaContrato = dataUltimoVencimentoDaUltimaParcelaContrato;
		this.formaLiquidacao = formaLiquidacao;
		this.origemBaixa = origemBaixa;
	}



	public String getIdentificacaoParticipanteAdministrado() {
		return identificacaoParticipanteAdministrado;
	}
	public void setIdentificacaoParticipanteAdministrado(String identificacaoParticipanteAdministrado) {
		this.identificacaoParticipanteAdministrado = identificacaoParticipanteAdministrado;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getTipoEmpregador() {
		return tipoEmpregador;
	}
	public void setTipoEmpregador(int tipoEmpregador) {
		this.tipoEmpregador = tipoEmpregador;
	}
	public int getBeneficioINSS() {
		return beneficioINSS;
	}
	public void setBeneficioINSS(int beneficioINSS) {
		this.beneficioINSS = beneficioINSS;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public int getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(int numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	public int getTipoOperacao() {
		return tipoOperacao;
	}
	public void setTipoOperacao(int tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	public int getTipoLiquidacao() {
		return tipoLiquidacao;
	}
	public void setTipoLiquidacao(int tipoLiquidacao) {
		this.tipoLiquidacao = tipoLiquidacao;
	}
	public Date getDataLiquidacaoAntecipada_Quitacao() {
		return dataLiquidacaoAntecipada_Quitacao;
	}
	public void setDataLiquidacaoAntecipada_Quitacao(Date dataLiquidacaoAntecipada_Quitacao) {
		this.dataLiquidacaoAntecipada_Quitacao = dataLiquidacaoAntecipada_Quitacao;
	}
	public Date getDataUltimoVencimentoDaUltimaParcelaContrato() {
		return dataUltimoVencimentoDaUltimaParcelaContrato;
	}
	public void setDataUltimoVencimentoDaUltimaParcelaContrato(Date dataUltimoVencimentoDaUltimaParcelaContrato) {
		this.dataUltimoVencimentoDaUltimaParcelaContrato = dataUltimoVencimentoDaUltimaParcelaContrato;
	}
	public int getFormaLiquidacao() {
		return formaLiquidacao;
	}
	public void setFormaLiquidacao(int formaLiquidacao) {
		this.formaLiquidacao = formaLiquidacao;
	}
	public String getOrigemBaixa() {
		return origemBaixa;
	}
	public void setOrigemBaixa(String origemBaixa) {
		this.origemBaixa = origemBaixa;
	}



	public String getCNPJEmpregador() {
		return CNPJEmpregador;
	}



	public void setCNPJEmpregador(String cNPJEmpregador) {
		CNPJEmpregador = cNPJEmpregador;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusRetornoCIP() {
		return statusRetornoCIP;
	}

	public void setStatusRetornoCIP(String statusRetornoCIP) {
		this.statusRetornoCIP = statusRetornoCIP;
	}



	public String getRetornoJsonCIP() {
		return retornoJsonCIP;
	}



	public void setRetornoJsonCIP(String retornoJsonCIP) {
		this.retornoJsonCIP = retornoJsonCIP;
	}
	
	

}
