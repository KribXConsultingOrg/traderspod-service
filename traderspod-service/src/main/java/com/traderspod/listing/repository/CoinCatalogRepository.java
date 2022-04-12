package com.traderspod.listing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traderspod.listing.domain.CoinCatalog;

public interface CoinCatalogRepository extends JpaRepository<CoinCatalog, Integer> {

}
