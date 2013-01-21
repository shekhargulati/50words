package com.fiftywords.controller;

import java.security.Principal;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fiftywords.domain.Account;
import com.fiftywords.jpa.repository.AccountRepository;
import com.fiftywords.utils.SecurityUtils;

@Controller
public class HomeController {

	private final Provider<ConnectionRepository> connectionRepositoryProvider;

	private final AccountRepository accountRepository;

	@Inject
	public HomeController(
			Provider<ConnectionRepository> connectionRepositoryProvider,
			AccountRepository accountRepository) {
		this.connectionRepositoryProvider = connectionRepositoryProvider;
		this.accountRepository = accountRepository;
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Principal currentUser, Model model) throws Exception {
		model.addAttribute("connectionsToProviders", getConnectionRepository()
				.findAllConnections());
		model.addAttribute(accountRepository.findAccountByUsername(currentUser
				.getName()));

		Account account = accountRepository.findAccountByUsername(SecurityUtils
				.getCurrentLoggedInUsername());

		return "home";
	}


	private ConnectionRepository getConnectionRepository() {
		return connectionRepositoryProvider.get();
	}

}
