package com.traderspod.listing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traderspod.listing.dto.input.ContestRequest;
import com.traderspod.listing.dto.output.ContestResponse;
import com.traderspod.listing.service.ContestService;

@RestController
@RequestMapping("/contests")
public class ContestController {

	@Autowired
	private ContestService contestService;

	@GetMapping
	public ResponseEntity<List<ContestResponse>> getContests() {
		List<ContestResponse> contests = contestService.fetchActiveAndUpcomingContests();
		if (contests != null && !contests.isEmpty()) {
			for (ContestResponse contestResponse : contests) {
				Link link = WebMvcLinkBuilder.linkTo(ContestController.class).withSelfRel();
				contestResponse.add(link);
			}
			return new ResponseEntity<List<ContestResponse>>(contests, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<ContestResponse>>(HttpStatus.NO_CONTENT);			
		}
	}

	@GetMapping(path = "/{contestId}")
	public ResponseEntity<ContestResponse> getContest(@PathVariable Integer contestId) {
		ContestResponse contest = contestService.fetchContestById(contestId);
		if (contest != null) {
			Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ContestController.class).getContest(contestId))
					.withSelfRel();
			contest.add(link);
			return new ResponseEntity<ContestResponse>(contest, HttpStatus.OK);
		} else {
			return new ResponseEntity<ContestResponse>(HttpStatus.NO_CONTENT);			
		}
	}

	@PostMapping
	public ResponseEntity<EntityModel<ContestResponse>> createContest(@Valid @RequestBody ContestRequest contestRequest) {
		ContestResponse contestResponse = contestService.createContest(contestRequest);
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ContestController.class).getContest(contestResponse.getContestId()))
				.withSelfRel();
		EntityModel<ContestResponse> result = EntityModel.of(contestResponse, link);
		return new ResponseEntity<EntityModel<ContestResponse>>(result, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{contestId}")
	public ResponseEntity<Integer> updateContest(@PathVariable Integer contestId, @RequestBody ContestRequest contestRequest) {
		contestId = contestService.updateContest(contestId, contestRequest);
		return new ResponseEntity<Integer>(contestId, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(path = "/{contestId}")
	public ResponseEntity<Integer> deleteContest(@PathVariable Integer contestId) {
		contestService.deleteContest(contestId);
		return new ResponseEntity<Integer>(contestId, HttpStatus.ACCEPTED);
	}
}
