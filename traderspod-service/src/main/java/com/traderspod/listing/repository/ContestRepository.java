package com.traderspod.listing.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traderspod.listing.domain.Contest;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Integer> {

	List<Contest> findAllByEndDateAfter(Timestamp currentDateTime);

}
