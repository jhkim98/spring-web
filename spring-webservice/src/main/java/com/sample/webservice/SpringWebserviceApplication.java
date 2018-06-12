package com.sample.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration //(exclude={DataSourceAutoConfiguration.class}) //https://discuss.gradle.org/t/spring-boot-with-gradle/20548
@PropertySource("classpath:application.properties")
public class SpringWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebserviceApplication.class, args);
	}
}
