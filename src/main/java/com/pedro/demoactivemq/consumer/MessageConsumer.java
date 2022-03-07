package com.pedro.demoactivemq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.pedro.demoactivemq.model.PedroMessage;

@Component
public class MessageConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);
	
	@JmsListener(destination = "Pedro-queue")
	public void messageListener(PedroMessage pedroMessage) {
		LOGGER.info("Message received. {}",pedroMessage);
	}
	
}
