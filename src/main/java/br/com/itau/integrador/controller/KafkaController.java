package br.com.itau.integrador.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.integrador.service.KafkaProducer;

@RestController
public class KafkaController {

	private final br.com.itau.integrador.service.KafkaProducer producer;

	public KafkaController(KafkaProducer producer) {
		this.producer = producer;
	}

	@PostMapping("/publish")
	public void writeMessageToTopic(@RequestBody String message) {
		this.producer.writeMessage(message);

	}

}
