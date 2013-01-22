package com.fiftywords.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fiftywords.domain.Challenge;
import com.fiftywords.domain.Duration;
import com.fiftywords.service.ChallengeService;
import com.fiftywords.utils.SecurityUtils;

@Controller
@RequestMapping("/challenges")
public class ChallengeController {

	@Inject
	private ChallengeService challengeService;

	@RequestMapping(value = "/createform", method = RequestMethod.GET)
	public ModelAndView createForm() {
		ModelAndView mv = new ModelAndView("challenge/create");
		mv.addObject("duration", Duration.values());
		return mv;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "text/html")
	public String createNewChallenge(@Valid Challenge challenge) {
		String loggedInUsername = SecurityUtils.getCurrentLoggedInUsername();
		challenge.setCreatedBy(loggedInUsername);
		challenge = challengeService.create(challenge);
		challengeService.scheduleTasks(challenge);
		return "redirect:/home";
	}
	
}
