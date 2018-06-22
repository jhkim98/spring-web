package com.sample.webservice.rabbitmq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class Testpro {


    public static void main(final String[] args) {
	    //RabbitMQ 연결
	    CachingConnectionFactory cf = new CachingConnectionFactory("127.0.0.1", 5672);
	    cf.setUsername("rabbitmq");
	    cf.setPassword("rabbitmq");
	 
	    //메시지 보내기
	    RabbitTemplate template = new RabbitTemplate(cf);
	    template.setExchange("amq.direct");
	    template.setQueue("myQueue");
	    template.convertAndSend("test", "Hello, world!" + System.currentTimeMillis() );
	    cf.destroy();
    }
}
