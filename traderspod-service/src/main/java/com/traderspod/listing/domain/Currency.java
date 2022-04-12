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
@Table(name = "CURRENCY", schema = "LISTING")
public class Currency {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

    @Column(name="SYMBOL")
	private String symbol;

    @Column(name="NAME")
	private String name;

	@Override
	public String toString() {
		return "Currency [id=" + id + ", symbol=" + symbol + ", name=" + name + "]";
	}

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
		Currency other = (Currency) obj;
		return Objects.equals(id, other.id);
	}

}
