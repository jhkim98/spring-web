package com.sample.webservice.rabbitmq;

import java.util.Date;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
/*@EnableScheduling*/
public class SampleRabbitMq {
	
	//  RabbitMQ
	@Value("${myqueue}")
	String queue;

	@Bean
	Queue queue(){
		return new Queue(queue, false);
	}

	@Autowired
	Producer producer;

/*    @Bean
	CommandLineRunner sender(Producer producer){
    	return args -> {
    		producer.sendTo(queue, "Hello !!!");
		};
	}*/

/* @Scheduled(fixedDelay = 5000L)*/
	public void sendScheduleMessage(){
		producer.sendTo(queue, "Message Delevery : " + new Date());
	}
	
}
