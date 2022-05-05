package com.traderspod.listing.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.traderspod.listing.ServiceApplicationTests;
import com.traderspod.listing.dto.output.ContestResponse;
import com.traderspod.listing.service.ContestService;

public class ContestControllerTest extends ServiceApplicationTests {


    @InjectMocks
    ContestController contestController;
     
    @Mock
    ContestService contestService;

    @Test
    public void testGetContests() {
    	
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ContestResponse contestResponse = new ContestResponse();
        contestResponse.setContestId(1);
        contestResponse.setTitle("Contest 1");
        List<ContestResponse> csl = new ArrayList<ContestResponse>();
        csl.add(contestResponse);
        when(contestService.fetchActiveAndUpcomingContests()).thenReturn(csl);
         
        ResponseEntity<List<ContestResponse>> responseEntity = contestController.getContests();
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().stream().findFirst().get().getContestId()).isEqualTo(1);
    }
}
