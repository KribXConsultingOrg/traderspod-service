package com.traderspod.listing.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ContestResponse extends RepresentationModel<ContestResponse> {

	private Integer contestId;
	private String title;
	private BigDecimal tradingAmount;
	private String currency;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private LocalDateTime lockDate;
	private String description;
	private String status;
	@Override
	public int hashCode() {
		return Objects.hash(contestId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContestResponse other = (ContestResponse) obj;
		return Objects.equals(contestId, other.contestId);
	}
	@Override
	public String toString() {
		return "ContestResponse [contestId=" + contestId + ", title=" + title + ", tradingAmount=" + tradingAmount
				+ ", currency=" + currency + ", startDate=" + startDate + ", endDate=" + endDate + ", lockDate="
				+ lockDate + ", description=" + description + ", status=" + status + "]";
	}
}
