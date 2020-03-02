package com.TestMq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabiitMqConfig {

	private static final String TESTQUEUE = "testQueue";
	private static final String TESTEXCHANGE = "testExchange";

	@Bean
	Queue queue() {
		// return new Queue(TESTQUEUE,false);
		return QueueBuilder.durable(TESTQUEUE).build();
	}

	@Bean
	Exchange exchange() {
		return ExchangeBuilder.directExchange(TESTEXCHANGE).build();
	}

	@Bean
	Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with("test").noargs();

	}

}
