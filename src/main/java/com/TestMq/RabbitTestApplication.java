package com.TestMq;


import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitTestApplication implements CommandLineRunner {
	
	private  static final org.slf4j.Logger LOGGER= LoggerFactory.getLogger(RabbitTestApplication.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabbitTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.debug("Sending a message");
		rabbitTemplate.convertAndSend("testExchange","test","Hello frst message");
		
	}

}
