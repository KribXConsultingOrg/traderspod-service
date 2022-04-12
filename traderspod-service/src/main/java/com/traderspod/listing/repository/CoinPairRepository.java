package com.traderspod.listing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traderspod.listing.domain.Contest;

public interface CoinPairRepository extends JpaRepository<Contest, Integer> {

}
