package com.vijai.rabbitmq.producer;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijai.rabbitmq.config.MessagingConfig;
import com.vijai.rabbitmq.dto.Dto;
import com.vijai.rabbitmq.dto.StatusDto;

@RestController
@RequestMapping("/dto")
public class MessagePublisher {

	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/{cid}")
	public String pass(@RequestBody Dto dto,@PathVariable String cid) {
		dto.setId(UUID.randomUUID().toString());
		
		StatusDto sDto= new StatusDto(dto, "Process", "eysxxxxgx");
		
		template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, sDto);
		return "Success";
		
	}
	
}
