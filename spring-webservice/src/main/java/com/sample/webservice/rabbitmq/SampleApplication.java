package com.sample.webservice.rabbitmq;

import java.util.Date;

import javax.sound.midi.Receiver;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SampleApplication {
	
/*	public SampleApplication() {
		
	};*/
	
/*	//  RabbitMQ
	@Value("${myqueue}")
	String queue;

	@Bean
	Queue queue(){
		return new Queue(queue, false);
	}

	@Autowired
	Producer producer;

    @Bean
	CommandLineRunner sender(Producer producer){
    	return args -> {
    		producer.sendTo(queue, "Hello !!!");
		};
	}

	@Scheduled(fixedDelay = 5000)
	public void sendScheduleMessage(){
		System.out.println("sendScheduleMessage Call");
		producer.sendTo(queue, "Message Delevery : " + new Date());
	}*/
	
	final static String queueName = "sampletest";

    @Bean
    Queue queue(){
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("spring-boot-exchange");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver){
        return new MessageListenerAdapter(receiver,"receiveMessage");
    }



	
}
