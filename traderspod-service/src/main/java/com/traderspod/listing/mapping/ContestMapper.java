package com.traderspod.listing.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.traderspod.listing.domain.Contest;
import com.traderspod.listing.dto.input.ContestRequest;
import com.traderspod.listing.dto.output.ContestResponse;

@Mapper(componentModel = "spring")
public interface ContestMapper {

	@Mapping(source = "id", target = "contestId")
	@Mapping(source = "currency.symbol", target = "currency")
    ContestResponse contestToContestResponse(Contest contest);

	/*
	 * @Mapping(source = "contestId", target = "id")
	 * 
	 * @Mapping(source = "currency", target = "currency.symbol") Contest
	 * contestResponseToContest(ContestResponse contestResponse);
	 * 
	 * @Mapping(source = "contestId", target = "id")
	 * 
	 * @Mapping(source = "currency", target = "currency.symbol") Contest
	 * contestRequestToContest(ContestRequest contestRequest);
	 */
}
