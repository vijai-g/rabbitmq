package com.vijai.rabbitmq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StatusDto {

	
	private Dto dto;
	private String status;
	private String message;
}
