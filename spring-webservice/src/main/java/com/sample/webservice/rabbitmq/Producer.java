package com.sample.webservice.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendTo(String routingKey, String message) {
		//System.out.println("send message");
		//rabbitTemplate.setExchange("amq.direct");
		this.rabbitTemplate.convertAndSend(routingKey, message);
	}
	
/*	
    CachingConnectionFactory cf = new CachingConnectionFactory("127.0.0.1", 5672);
    cf.setUsername("rabbitmq");
    cf.setPassword("rabbitmq");
 
    //메시지 보내기
    RabbitTemplate template = new RabbitTemplate(cf);
    template.setExchange("amq.direct");
    template.setQueue("myQueue");
    template.convertAndSend("test", "Hello, world!" + System.currentTimeMillis() );
    cf.destroy();*/
}
