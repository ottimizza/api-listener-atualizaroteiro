package br.com.ottimizza.atualizaroteiro.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.ottimizza.atualizaroteiro.service.AtualizaRoteirosService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class KafkaConsumers {

    @Autowired
    public KafkaProperties kafkaProperties;

    @Autowired
    public AtualizaRoteirosService service;

	@Autowired
    @KafkaListener(topics = "#{kafkaProperties.getPrefix()}ottimizza.exportar.regras.oud", 
            	   groupId = "#{kafkaProperties.getPrefix()}tareffa-queue-events-group")
    public void integraArquivo(@Payload String message) throws JsonProcessingException, JsonMappingException {
    	
    	try {
    		service.salvaAtualizaRoteiros(message);
    	} catch (Exception e) {
    		System.out.println("Error service.atualizaRoteiro --> "+e.getMessage());
		}

    }
}
