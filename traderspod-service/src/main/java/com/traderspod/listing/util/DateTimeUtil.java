package com.traderspod.listing.util;


import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public final class DateTimeUtil {

	public static LocalDateTime currentDateTime() {
		return LocalDateTime.now();	
	}
}
