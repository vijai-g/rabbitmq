package com.vijai.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessagingConfig {

	
	public static final String QUEUE ="the_queue";
	public static final String EXCHANGE ="the_exchange";
	public static final String ROUTING_KEY ="the_routing_key";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE);
		
	}
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
		
	}
	@Bean
	public Binding bind(Queue q, TopicExchange ex) {
		return BindingBuilder.bind(q).to(ex).with(ROUTING_KEY);
	}
	
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		
		return rabbitTemplate;
		}
}
