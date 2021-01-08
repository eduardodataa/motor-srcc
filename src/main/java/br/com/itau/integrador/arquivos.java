package br.com.itau.consignado.deserializer;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.itau.consignado.model.ContratoPortabilidade;

public class ContratoPortabilidadeDeserializer implements Deserializer<ContratoPortabilidade> {

	@Override
	public ContratoPortabilidade deserialize(String topic, byte[] data) {

		try {
			return new ObjectMapper().readValue(data, ContratoPortabilidade.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}


package br.com.itau.consignado.enums;

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



package br.com.itau.consignado.enums;

public enum TipoEmpregadorEnum {
	
	INSS(1),
	OUTROS(2);

	TipoEmpregadorEnum(int i) {
		// TODO Auto-generated constructor stub
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}


package br.com.itau.consignado.enums;

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



package br.com.itau.consignado.exception;

public class LiquidacaoContratoServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LiquidacaoContratoServiceException(String erroTipoOperacao) {
		// TODO Auto-generated constructor stub
	}
	

}



package br.com.itau.consignado.model;

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




package br.com.itau.consignado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.consignado.model.ContratoPortabilidade;

@Repository
public interface ContratoPortabilidadeRepository extends JpaRepository<ContratoPortabilidade, Long>{

}



package br.com.itau.consignado.service;

import org.springframework.stereotype.Service;

@Service
public class AuditoriaSRCCService {
	
	public void persistirInformacoes() {
		//criar repositório
		
	}

}




package br.com.itau.consignado.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepService {

	@GetMapping("{cep}/json")
    Endereco buscaEnderecoPorCep(@PathVariable("cep") String cep);
	
}




package br.com.itau.consignado.service;

public class Dados {

}


package br.com.itau.consignado.service;

public class Endereco {

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getIbge() {
		return ibge;
	}
	public void setIbge(String ibge) {
		this.ibge = ibge;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getSiafi() {
		return siafi;
	}
	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}
	
	
}



package br.com.itau.consignado.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import br.com.itau.consignado.exception.LiquidacaoContratoServiceException;
import br.com.itau.consignado.model.ContratoPortabilidade;
import br.com.itau.consignado.validation.LiquidacaoContratoValidation;

@Service
public class KafkaConsumerSRCC {
	
	@Autowired
	public LiquidacaoContratoService liquidacaoContratoService; 
	
	@Autowired
	public LiquidacaoContratoValidation liquidacaoContratoValidation;  
	
	
	@Autowired
	public CepService cepService;  
	

    @KafkaListener(topics="my_topic", groupId="my_group_id")
    public void getMessage(String message){
    	

    	try {
    		servicoCepFake(message);
    		
    		ContratoPortabilidade contratoPortabilidade = carregarJson(message);
    		liquidacaoContratoValidation.validarAtributosMotorSRCC(contratoPortabilidade);
    		liquidacaoContratoService.motorRegrasContrato(contratoPortabilidade);
		} catch (LiquidacaoContratoServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

	private void servicoCepFake(String message) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		Endereco cep = mapper.readValue(message.toString(), Endereco.class);

		Endereco endereco = cepService.buscaEnderecoPorCep(cep.getCep().toString());
		System.out.println(endereco.getCep());
		System.out.println(endereco.getBairro());
		System.out.println(endereco.getLogradouro());
		
	}


	public ContratoPortabilidade carregarJson(String message){
		try {
			Gson gson = new Gson();
			ContratoPortabilidade contratoPortabilidade = gson.fromJson(message.toString(), ContratoPortabilidade.class);
			System.out.println("ToString objeto: " + contratoPortabilidade.toString());
			
			return contratoPortabilidade;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
}



package br.com.itau.consignado.service;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerSRCC {

	private Properties kafkaConfiguration() {
		Properties p = new Properties();
		p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		return p;
	}

	public void enviarMensagem(String message) {
		try (KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(kafkaConfiguration())) {
			ProducerRecord<String, String> record = new ProducerRecord<String, String>("my_topic", message);
			kafkaProducer.send(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



package br.com.itau.consignado.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.itau.consignado.exception.LiquidacaoContratoServiceException;
import br.com.itau.consignado.model.ContratoPortabilidade;
import br.com.itau.consignado.repositories.ContratoPortabilidadeRepository;

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
	public void motorRegrasContrato(ContratoPortabilidade contratoPortabilidade) throws LiquidacaoContratoServiceException{

    	
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


	/**
	 * Compara somente o mês e o ano entre duas datas
	 * @param Data 1 e Data 2
	 * @return
	 */
	private boolean compararMesAnoEntreDatas(Date data1, Date data2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(data1);
		cal2.setTime(data2);
		boolean mesmoMesAno = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
		              cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
		return mesmoMesAno;
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


	private void registrarNaCIP(ContratoPortabilidade contratoPortabilidade) {
		//1.	Enviar Json com a respectiva operação (registro/inativação/alteração) pra CIP
			//a. Guardar numa lista em memória 

		//2.	CIP envia o retorno (com sucesso ou fracasso da operação)
		
		//3.	MS ao receber o retorno da CIP salva (criar uma coluna para cada item abaixo):
			//a.	Json de envio
			//b.	Json de retorno da CIP (contém a situação de sucesso ou fracasso)

		
	}

	
	public void salvarContratoPortabilidade(String strContratoPortabilidade) {
		
		ContratoPortabilidade contratoPortabilidade = new Gson().fromJson(strContratoPortabilidade.toString(), ContratoPortabilidade.class);
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



package br.com.itau.consignado.validation;

import org.springframework.stereotype.Service;

import br.com.itau.consignado.enums.TipoOperacaoEnum;
import br.com.itau.consignado.exception.LiquidacaoContratoServiceException;
import br.com.itau.consignado.model.ContratoPortabilidade;

@Service
public class LiquidacaoContratoValidation {
	
	


	public void validarAtributosMotorSRCC(ContratoPortabilidade contratoPortabilidade) throws LiquidacaoContratoServiceException {
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
    private boolean tipoOperacaoValida(Long operacao) throws LiquidacaoContratoServiceException {
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
	private boolean clienteValido(Long cliente) throws LiquidacaoContratoServiceException {
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





application.yml
server:
  port: 8081
spring:
  kafka:
    consumer:
      bootstrap-servers: localhost:9092
      group-id: "my_group_id"
      auto-offset-reset: earliest
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
#    producer:
#      bootstarp-servers: locahost:9092
#      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
#      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
  datasource:
    url: jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    platform: h2
    username: 
    password:
    driverClassName: org.h2.Driver
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        show_sql: true
        use_sql_comments: true
        format_sql: true

###
#   H2 Settings
###
  h2:
    console:
      enabled: true
      path: /console
      settings:
        trace: false
        web-allow-others: false   
        
        
        
contrato.json        
{
  "operacao": 1,
  "cliente": 123,
  "dataInicio": "2020-01-01",
  "dataPortabilidade": "2020-01-01",
  "valorTotal": 100000.00,
  "status": "A"
}





































