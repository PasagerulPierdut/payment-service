package com.accenture.paymentprocessor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJcaListenerContainerFactory;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

@SpringBootApplication
@EntityScan(basePackages = "com.accenture.*")
public class PaymentProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentProcessorApplication.class, args);
	}

	@Bean
	public JmsListenerContainerFactory<?> processorFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory processorFactory = new DefaultJmsListenerContainerFactory();
		configurer.configure(processorFactory, connectionFactory);
		return processorFactory;
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter () {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JSR310Module());
		converter.setObjectMapper(objectMapper);

		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");

		return converter;
	}
}
