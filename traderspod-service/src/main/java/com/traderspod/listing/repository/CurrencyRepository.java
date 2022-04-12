package com.traderspod.listing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traderspod.listing.domain.CoinPair;

public interface CurrencyRepository extends JpaRepository<CoinPair, Integer> {

}
