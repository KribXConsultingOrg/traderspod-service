package com.traderspod.listing.dto.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ContestRequest {

	private Integer contestId;
	@NotNull
	private String title;
	@NotNull
	private BigDecimal tradingAmount;
	@NotNull
	private String currency;
	@NotNull
	private LocalDateTime startDate;
	@NotNull
	private LocalDateTime endDate;
	@NotNull
	private LocalDateTime lockDate;
	@NotNull
	private String description;
	private String status;

	@Override
	public String toString() {
		return "ContestResponse [contestId=" + contestId + ", title=" + title + ", tradingAmount=" + tradingAmount
				+ ", currency=" + currency + ", startDate=" + startDate + ", endDate=" + endDate + ", lockDate="
				+ lockDate + ", description=" + description + ", status=" + status + "]";
	}

}