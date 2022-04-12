package com.traderspod.listing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traderspod.listing.domain.CoinPrice;


public interface CoinPriceRepository extends JpaRepository<CoinPrice, Long> {

}
