package com.sample.webservice.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendTo(String routingKey, String message) {
		System.out.println("send message");
		this.rabbitTemplate.convertAndSend(routingKey, message);
	}
}
