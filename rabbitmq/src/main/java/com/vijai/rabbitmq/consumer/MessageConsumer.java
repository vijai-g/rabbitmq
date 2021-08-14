package com.vijai.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.vijai.rabbitmq.config.MessagingConfig;
import com.vijai.rabbitmq.dto.StatusDto;

@Component
public class MessageConsumer {

	@RabbitListener(queues=MessagingConfig.QUEUE)
	public void consumerMessageFromQueue(StatusDto statusDto) {
		System.out.println("Received message" + statusDto);
	}
}
