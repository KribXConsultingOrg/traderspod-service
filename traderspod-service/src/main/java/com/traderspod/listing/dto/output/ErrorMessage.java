package com.traderspod.listing.dto.output;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ErrorMessage {

	private String message;
	private LocalDateTime timestamp;

	public ErrorMessage() {
	}
	public ErrorMessage(String message, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.timestamp = timestamp;
	}
}
