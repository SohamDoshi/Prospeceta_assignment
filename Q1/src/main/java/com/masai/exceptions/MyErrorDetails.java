package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@RestControllerAdvice
public class MyErrorDetails {

	private LocalDateTime timestamp;
	private String message;
	private String description;

	
}
