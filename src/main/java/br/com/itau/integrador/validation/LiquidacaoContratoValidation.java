package br.com.itau.integrador.validation;


import org.springframework.stereotype.Service;

import br.com.itau.integrador.entity.ContratoPortabilidade;
import br.com.itau.integrador.enums.TipoOperacaoEnum;
import br.com.itau.integrador.exception.LiquidacaoContratoServiceException;

@Service
public class LiquidacaoContratoValidation {
	
	


	public void validarAtributosMotorSRCC(ContratoPortabilidade contratoPortabilidade)  {
		//serviço - condições do fluxo de liquidação antecipada
    	//validações
//    	if(clienteValido(contratoPortabilidade.getCliente())) {
//    		
//    	}
//    	if(tipoOperacaoValida(contratoPortabilidade.getOperacao())) {
//    		
//    	}
//    	if(tipoEmpregadorValido(contratoPortabilidade.getCliente())) {
//    		
//    	}
		
		// regra: se tem INSS não tem matrícula e vice versa
		
		// TODO - criar lista com registros defeituosos para armazenar na auditoria
	}
	
	/**
	 * Realiza as validações relacionadas ao tipo de operação
	 * @param operacao
	 * @return
	 * @throws LiquidacaoContratoServiceException
	 */
    private boolean tipoOperacaoValida(Long operacao)   {
		if(operacao != TipoOperacaoEnum.LIQUIDACAO_ANTECIPADA.getId()) {
			//throw new LiquidacaoContratoServiceException(ERRO_TIPO_OPERACAO + " Tpo de operação enviada: "+operacao+". Tipo de operação esperada: "+TipoOperacaoEnum.LIQUIDACAO_ANTECIPADA + ".");
		}
		return true;
	}

    /**
     * Valida informações vinculadas ao CPF do cliente
     * @param cliente
     * @return
     * @throws LiquidacaoContratoServiceException
     */
	private boolean clienteValido(Long cliente)   {
		// TODO cliente > 0 - cliente tem que existir
		if(cliente <= 0l) {
			//throw new LiquidacaoContratoServiceException(ERRO_CLIENTE);
		}

		// TODO buscar cliente na base com chave criptografada
		boolean cpfCriptografadoValido = true;
		if(!cpfCriptografadoValido) {
			//throw new LiquidacaoContratoServiceException(ERRO_CLIENTE);
		}
		return true;
	}

}

