package br.com.itau.integrador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import br.com.itau.integrador.entity.ContratoPortabilidade;
import br.com.itau.integrador.entity.Endereco;

@Service
public class KafkaConsumerService {


	@Autowired
	public LiquidacaoContratoService liquidacaoContratoService; 
	
	@Autowired
	public LiquidacaoContratoValidation liquidacaoContratoValidation;  
	
	@Autowired
	private CepService cepService;

	@KafkaListener(topics = "my_topic", groupId = "my_group_id")
	public void getMessage(String message) {

		try {
			servicoCepFake(message);

			ContratoPortabilidade contratoPortabilidade = carregarJson(message);
			liquidacaoContratoValidation.validarAtributosMotorSRCC(contratoPortabilidade);
			liquidacaoContratoService.motorRegrasContrato(contratoPortabilidade);
//		} catch (LiquidacaoContratoServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
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

	public ContratoPortabilidade carregarJson(String message) {
		try {
			Gson gson = new Gson();
			ContratoPortabilidade contratoPortabilidade = gson.fromJson(message.toString(),
					ContratoPortabilidade.class);
			System.out.println("ToString objeto: " + contratoPortabilidade.toString());

			return contratoPortabilidade;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
