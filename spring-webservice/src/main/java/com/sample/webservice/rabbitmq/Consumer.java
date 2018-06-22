package com.sample.webservice.rabbitmq;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@RabbitListener(queues="${myqueue}")
	public void handle(String message) {
			System.out.println("message=>" + message);
	}
}
