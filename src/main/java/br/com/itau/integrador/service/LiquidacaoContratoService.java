package br.com.itau.integrador.service;


import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.itau.integrador.entity.ContratoPortabilidade;
import br.com.itau.integrador.exception.LiquidacaoContratoServiceException;
import br.com.itau.integrador.repositories.ContratoPortabilidadeRepository;

@Service
public class LiquidacaoContratoService {

	@Autowired
	private ContratoPortabilidadeRepository repository;
	
	
    private static final String ERRO_IDENTIFICACAO_PARTICIPANTE = "Erro ao carregar Participante Administrado.";
    private static final String ERRO_CNPJ_EMPREGADOR= "Erro ao carregar CPNJ Empregador.";
    private static final String ERRO_NUMERO_CPF = "Erro ao carregar número do CPF.";
    private static final String ERRO_CLIENTE = "Erro ao carregar o cliente.";
    private static final String ERRO_BENEFICIO_INSS = "Erro ao carregar benefício INSS.";
    private static final String ERRO_TIPO_OPERACAO = "Erro ao validar o tipo da operação.";

	
	/**
	 * Regras de Negócios 
		Regra	Descrição da Regra	Validação da Regra
			1 - Portabilidade de Outra IF	
				Caso o motivo da baixa for pelo motivo de Portabilidade de Outra IF, não devemos registrar na CIP	
				Validar o não registro na CIP
			2 - Refinanciamento de Carteira	
				Caso o motivo da baixa for pelo motivo de Refinananciamento de Carteira, não devemos registrar na CIP	
				Validar o não registro na CIP
			3 - Liquidação no último mês do contrato	
				Caso a baixa acontecer no último mês do contrato, não devemos registrar na CIP	 
				Validar o não registro na CIP
			4 - Renegociação do Contrato	
				Caso o motivo de baixa for pelo motivo de renegociação, devemos registrar na CIP	
				Validar o registro na CIP
			5 - Fraude	
				Caso o motivo de baixa for pelo motivo de fraude, devemos registrar na CIP	
				Validar o registro na CIP
			6 - Inativação do Registro na CIP	
				Caso o contrato seja cancelado por arrependimento do cliente devemos enviar um comando de exclusão do registro na CIP	  
				Validar a inativação do registro na CIP
	 * @param contratoPortabilidade
	 * @throws LiquidacaoContratoServiceException 
	 */
	public void motorRegrasContrato(ContratoPortabilidade contratoPortabilidade)  {

    	
    	//mapear entidade que vamos fazer o teste
		
		//criar a entidade de envio à CIP 
		
		
		
		
//		//1ª regra Se for portabilidade de outra IF, não registra na CIP
//		if(contratoPortabilidade.getFormaLiquidacao() == FormaLiquidacaoEnum.PORTABILIDADE_ATAQUE_OUTRO_BANCO.getId()) {
//			naoRegistrarNaCIP(contratoPortabilidade);
//		}
//
//		//2ª regra Se for REFIN DE CARTEIRA, não registra na CIP
//		if(contratoPortabilidade.getFormaLiquidacao() == FormaLiquidacaoEnum.REFINANCIAMENTO_CARTEIRA.getId()) {
//			naoRegistrarNaCIP(contratoPortabilidade);
//		}
//
//		//3ª regra Se Data Liquidação == último mês de vencimento do contrato
//		boolean mesmoMesAno = compararMesAnoEntreDatas(contratoPortabilidade.getDataUltimoVencimentoDaUltimaParcelaContrato(), contratoPortabilidade.getDataLiquidacaoAntecipada_Quitacao());
//		if(mesmoMesAno) {
//			naoRegistrarNaCIP(contratoPortabilidade);
//		}
		

    	//Regras de negócio
    		//registrar na SRCC
		registrarNaCIP(contratoPortabilidade);
    		//não registrar na SRCC
		naoRegistrarNaCIP(contratoPortabilidade);
    		//inativar na SRCC
		inativarRegistroNaCIP(contratoPortabilidade);
    		//alterar dados na SRCC (???)
		alterarRegistroNaCIP(contratoPortabilidade);
    	
	}





	private void alterarRegistroNaCIP(ContratoPortabilidade contratoPortabilidade) {
		// TODO Auto-generated method stub
		
	}


	private void inativarRegistroNaCIP(ContratoPortabilidade contratoPortabilidade) {
		// TODO Auto-generated method stub
		
	}


	private void naoRegistrarNaCIP(ContratoPortabilidade contratoPortabilidade) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Método responsável por enviar o contrato a ser registrado na CIP
	 * @param contratoPortabilidade
	 */
	private void registrarNaCIP(ContratoPortabilidade contratoPortabilidade) {
		//1.Montar Json	com a respectiva operação (registro/inativação/alteração) pra CIP
		//2. Enviar Json 
			//[PENDENTE] descobrir forma de comunicação com a CIP
		String jsonEnviarCIP = "jsonEnviarCIP";
		
			//a. Guardar numa lista em memória 

		//2.	CIP envia o retorno (com sucesso ou fracasso da operação)
		String jsonRetornoCIP = "jsonRetornoCIP";
		
		//3.	MS ao receber o retorno da CIP salva (criar uma coluna para cada item abaixo):
			//a.	Json de envio
			//b.	Json de retorno da CIP (contém a situação de sucesso ou fracasso)
		salvarContratoPortabilidade(contratoPortabilidade);
		
	}

	
	public void salvarContratoPortabilidade(ContratoPortabilidade contratoPortabilidade) {
		
		//envio pra CIP
		
		//recebimento retorno CIP
		String retornoCIP = "método de retorno da CIP";
		
		contratoPortabilidade.setStatusRetornoCIP("aceito"); //sitRet: "aceito"
		//guardar em outra coluna
		contratoPortabilidade.setRetornoJsonCIP(retornoCIP);
//			String json = 
//						sitRet: "aceito"
//				        numCPF: "12345678901"
//				        tpEmpregador: 1
//				        numBeneficio: "1234567890"
//				        numMatricula: "12345678901234567890"
//				        numContrato: "12345678901234567890123456789012345678901234567890"
//        	"
		
		this.repository.save(contratoPortabilidade);
	}
	
	
	
}
