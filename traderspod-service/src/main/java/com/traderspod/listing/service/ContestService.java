package com.traderspod.listing.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.traderspod.listing.domain.Contest;
import com.traderspod.listing.dto.ContestResponse;
import com.traderspod.listing.mapping.ContestMapper;
import com.traderspod.listing.repository.ContestRepository;
import com.traderspod.listing.util.DateTimeUtil;

@Service
@Transactional
public class ContestService {
	private static final Logger logger = Logger.getLogger(ContestService.class.getName());

	@Autowired
	private ContestRepository contestRepository;

	@Autowired
	private ContestMapper contestMapper;

	public List<ContestResponse> fetchActiveAndUpcomingContests() {
		logger.info(DateTimeUtil.currentDateTime().toString());
		List<Contest> contests = contestRepository.findAll();

		List<ContestResponse> contestResponses = contests.stream().map(contest ->
		contestMapper.contestToContestResponse(contest))
				.collect(Collectors.toList());
		return contestResponses;
	}

	public ContestResponse fetchContestById(Integer contestId) {
		logger.info("Fetching Contest Details for Id :: " + contestId);
		Optional<Contest> contest = contestRepository.findById(contestId);

		ContestResponse contestResponse = contestMapper.contestToContestResponse(contest.get());
		return contestResponse;
	}
	public List<Contest> createContest(Contest contest) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contest> updateContest(Contest contest) {
		// TODO Auto-generated method stub
		return null;
	}
}
