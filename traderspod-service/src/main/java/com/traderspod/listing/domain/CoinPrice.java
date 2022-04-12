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
@Table(name = "COIN_PRICE", schema = "LISTING")
public class CoinPrice {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COIN_PAIR_ID")
	private CoinPair coinPair;

    @Column(name="PRICE")
	private BigDecimal price;

    @Column(name="UPDATE_TIME")
	private Timestamp updateTime;

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
		CoinPrice other = (CoinPrice) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CoinPrice [id=" + id + ", coinPair=" + coinPair + ", price=" + price + ", updateTime=" + updateTime
				+ "]";
	}
}
