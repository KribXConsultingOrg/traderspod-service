package com.traderspod.listing.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "COIN_CATALOG", schema = "LISTING")
public class CoinCatalog {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "SHORT_DESC")
	private String shortDesc;

	@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "COIN_PAIR_ID")
	private List<CoinPair> coinPairs;

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
		CoinCatalog other = (CoinCatalog) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CoinCatalog [id=" + id + ", shortDesc=" + shortDesc + "]";
	}
}
