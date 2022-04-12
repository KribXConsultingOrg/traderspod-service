package com.traderspod.listing.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "CONTEST", schema = "LISTING")
public class Contest {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

    @Column(name="TITLE", length=100)
	private String title;

    @Column(name="TRADING_AMOUNT")
	private BigDecimal tradingAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CURRENCY_ID")
	private Currency currency;

    @Column(name="START_DATE")
	private Timestamp startDate;

    @Column(name="END_DATE")
	private Timestamp endDate;

    @Column(name="LOCK_DATE")
	private Timestamp lockDate;

    @Column(name="DESCRIPTION")
	private String description;

    @Column(name="STATUS")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COIN_CATALOG_ID")
	private CoinCatalog coinCatalog;

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contest other = (Contest) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Contest [id=" + id + ", title=" + title + ", tradingAmount=" + tradingAmount + ", currency=" + currency
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", lockDate=" + lockDate + ", description="
				+ description + ", status=" + status + "]";
	}
}
