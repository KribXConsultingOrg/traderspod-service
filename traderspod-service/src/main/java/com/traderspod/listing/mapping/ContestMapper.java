package com.traderspod.listing.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.traderspod.listing.domain.Contest;
import com.traderspod.listing.dto.ContestResponse;

@Mapper(componentModel = "spring")
public interface ContestMapper {
	@Mapping(source = "id", target = "contestId")
	@Mapping(source = "currency.symbol", target = "currency")
    ContestResponse contestToContestResponse(Contest contest);
}
