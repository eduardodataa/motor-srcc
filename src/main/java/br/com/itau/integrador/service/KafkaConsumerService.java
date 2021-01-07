package br.com.itau.integrador.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.itau.integrador.entity.Endereco;

@Service
public class KafkaConsumerService {

	@Autowired
	private CepService cepService;

	@KafkaListener(topics = "my_topic", groupId = "my_group_id")
	public void getMessage(String message) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		Endereco cep = mapper.readValue(message.toString(), Endereco.class);

		Endereco endereco = cepService.buscaEnderecoPorCep(cep.getCep().toString());
		System.out.println(endereco.getCep());
		System.out.println(endereco.getBairro());
		System.out.println(endereco.getLogradouro());
		
	}
	
}
