package com.fiftywords.controller;

import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fiftywords.domain.Challenge;
import com.fiftywords.service.ChallengeService;

@Controller
@RequestMapping("/challenges")
public class ChallengeController {

	@Inject
	private ChallengeService challengeService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST,headers = "Accept=application/json")
	public ResponseEntity<String> createNewChallenge(@RequestBody String json) {
		Challenge request = Challenge.fromJson(json);
		Challenge challenge = challengeService.create(request);
		challengeService.scheduleTasks(challenge);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<String>(challenge.getId(),headers,HttpStatus.CREATED);
	}
}
