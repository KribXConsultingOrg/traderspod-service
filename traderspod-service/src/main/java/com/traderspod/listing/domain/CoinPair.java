package com.traderspod.listing.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "COIN_PAIR", schema = "LISTING")
public class CoinPair {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

    @Column(name="SYMBOL")
	private String symbol;

    @Column(name="BASE_ASSET")
	private String baseAsset;

    @Column(name="QUOTE_ASSET")
	private String quoteAsset;

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
		CoinPair other = (CoinPair) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CoinPair [id=" + id + ", symbol=" + symbol + ", baseAsset=" + baseAsset + ", quoteAsset=" + quoteAsset
				+ "]";
	}
    
}
