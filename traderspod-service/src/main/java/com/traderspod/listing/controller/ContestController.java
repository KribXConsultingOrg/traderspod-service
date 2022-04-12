package com.traderspod.listing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.traderspod.listing.domain.Contest;
import com.traderspod.listing.dto.ContestResponse;
import com.traderspod.listing.service.ContestService;

@RestController
public class ContestController {

	@Autowired
	private ContestService contestService;

	@RequestMapping(value = "/contests", method = RequestMethod.GET, produces = "application/json")
	public List<ContestResponse> getContests() {
		List<ContestResponse> contests = contestService.fetchActiveAndUpcomingContests();
		for (ContestResponse contestResponse : contests) {
			Link link = WebMvcLinkBuilder.linkTo(ContestController.class).withSelfRel();
			contestResponse.add(link);
		}
		return contests;
	}

	@RequestMapping(value = "/contests/{contestId}", method = RequestMethod.GET, produces = "application/json")
	public EntityModel<ContestResponse> getContestById(@PathVariable final Integer contestId) {
		ContestResponse contest = contestService.fetchContestById(contestId);
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ContestController.class)
				.getContestById(contestId)).withSelfRel();
		EntityModel<ContestResponse> result = EntityModel.of(contest, link);
		return result;
	}

	@RequestMapping(value = "/contest", method = RequestMethod.POST)
	public List<Contest> createContest(Contest contest) {
		return contestService.createContest(contest);
	}

	@RequestMapping(value = "/contest", method = RequestMethod.PUT)
	public List<Contest> updateContest(Contest contest) {
		return contestService.updateContest(contest);
	}

}
