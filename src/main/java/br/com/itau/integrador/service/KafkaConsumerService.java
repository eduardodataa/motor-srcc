package br.com.itau.integrador.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics="my_topic", groupId="my_group_id")
    public void getMessage(String message){
    	
        System.out.println(message.toString());

    }
}
