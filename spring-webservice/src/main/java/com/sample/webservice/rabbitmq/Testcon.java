package com.sample.webservice.rabbitmq;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

public class Testcon {
	  public static void main(String[] args) {
	        //RabbitMQ 연결
	    CachingConnectionFactory cf = new CachingConnectionFactory("127.0.0.1", 5672);
	    cf.setUsername("rabbitmq");
	    cf.setPassword("rabbitmq");
	        
	    //큐 생성
        RabbitAdmin admin = new RabbitAdmin(cf);
        Queue queue = new Queue("myQueue");
        admin.declareQueue(queue);
	 
	    //Exchange에 바인딩
        DirectExchange exchange = new DirectExchange("amq.direct");
        admin.declareBinding(BindingBuilder.bind(queue).to(exchange).with("test"));    
	                
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cf);
        Object listener = new Object() {
            //메시지 처리
            public void handleMessage(Object foo) {
            	System.out.println("********Message Start*******");
                System.out.println(foo);
                System.out.println("********Message End  *******");
            }
        };
            
             //메시지 리스닝
        MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
        container.setMessageListener(adapter);
        container.setQueueNames("myQueue");
        container.start();
    }
}


