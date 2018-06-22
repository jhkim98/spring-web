package com.sample.webservice.web;

import java.util.Date;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.webservice.rabbitmq.Producer;
import com.sample.webservice.rabbitmq.SampleApplication;

@RestController
public class WebRestController {

	
	//  RabbitMQ
/*	@Value("${myqueue}")
	String queue;
	
	@Autowired
	Producer producer;
	
	@Bean
	Queue queue(){
		return new Queue(queue, false);
	}
	
    @GetMapping("/send")
    public void send() {
    	System.out.println("producer.sendTo Call");
		producer.sendTo(queue, "Message Delevery : " + new Date());
    }*/
    
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
    
    
}