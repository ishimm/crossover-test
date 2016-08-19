package com.crossover.ishim.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.provider.ProviderAccountRequest;
import com.stormpath.sdk.provider.ProviderAccountResult;
import com.stormpath.sdk.provider.Providers;
import com.stormpath.sdk.servlet.account.AccountResolver;
import com.stormpath.sdk.servlet.http.Resolver;

/**
 * Maps a URI and resolves to a Thymeleaf template
 * @author Ishim Manon
 *
 */
@Controller
public class SecurityController {
	@Autowired
	Application app;

	@Value("#{ @environment['web.cross.link'] }")
	String crossLink;

	private static final String CLIENT_ID = "184853843360-m9uc4g0i5gve2osmcl98gaq125r7ghvr.apps.googleusercontent.com";
	private static final String APPLICATION_NAME = "ishimcrossover";
	private ArrayList<String> scopes = new ArrayList<String>();
	
	@Autowired
	Resolver<String> stormpathOrganizationNameKeyResolver;

	@RequestMapping("/loginStaff")
	public String loginStaff(Model model, HttpServletRequest req) {
		Account account = AccountResolver.INSTANCE.getAccount(req);
		if (account != null) {
			String org = getOrganizationNameKey(req);
			if (org != null && account.getApplications().getSize() > 1) {
				model.addAttribute("crossLink", "//" + org + "." + crossLink);
			}
			String templateSuffix = (org == null) ? "user" : org;
			return "restricted/" + templateSuffix;
		}
		return "redirect:/login";
	}

	@RequestMapping("/googleLogin")
	public String googleLogin(Model model, HttpServletRequest req, HttpServletResponse resp) {

		String token = generateToken(req);
		scopes.add("profile");
		scopes.add("email");
		OAuth2ClientProperties oauthProperties = new OAuth2ClientProperties();
	      // Redirect to the Google OAuth 2.0 authorization endpoint
		String url = new GoogleAuthorizationCodeRequestUrl(oauthProperties.getClientId(),
	          "", scopes).build();
	      try {
			resp.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		ProviderAccountRequest request = Providers.GOOGLE.account()
				.setCode("4/a3p_fn0sMDQlyFVTYwfl5GAj0Obd.oiruVLbQZSwU3oEBd8DOtNApQzTCiwI")
				.build();	

		ProviderAccountResult result = app.getAccount(request);
		Account account = result.getAccount();
		model.addAttribute("account", account);
		req.setAttribute("account", account);
		return "redirect:/restricted/user";
	}
	
	@RequestMapping("/twitterLogin")
	public String twitterLogin(Model model, HttpServletRequest req, HttpServletResponse resp) {
		//TODO: Implement Auth with Twitter
		Account account = AccountResolver.INSTANCE.getAccount(req);
		if (account != null) {
			String org = getOrganizationNameKey(req);
			if (org != null && account.getApplications().getSize() > 1) {
				model.addAttribute("crossLink", "//" + org + "." + crossLink);
			}
			return "restricted:/restricted/user";
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/linkedinLogin")
	public String linkedinLogin(Model model, HttpServletRequest req, HttpServletResponse resp) {
		//TODO: Implement Auth with LinkedIn
		Account account = AccountResolver.INSTANCE.getAccount(req);
		if (account != null) {
			String org = getOrganizationNameKey(req);
			if (org != null && account.getApplications().getSize() > 1) {
				model.addAttribute("crossLink", "//" + org + "." + crossLink);
			}
			return "restricted:/restricted/user";
		}
		return "redirect:/login";
	}

	/**
	 * Generates a token needed for google auth 
	 * @param req
	 * @return
	 */
	private String generateToken(HttpServletRequest req) {
		// Create a state token to prevent request forgery.
		// Store it in the session for later validation.
		String state = new BigInteger(130, new SecureRandom()).toString(32);
		req.getSession().setAttribute("state", state);
		// Read index.html into memory, and set the client ID,
		// token state, and application name in the HTML before serving it.
		try {
			String scanner = new Scanner(new File("index.html"), "UTF-8")
			.useDelimiter("\\A").next()
			.replaceAll("[{]{2}\\s*CLIENT_ID\\s*[}]{2}", CLIENT_ID)
			.replaceAll("[{]{2}\\s*STATE\\s*[}]{2}", state)
			.replaceAll("[{]{2}\\s*APPLICATION_NAME\\s*[}]{2}",
					APPLICATION_NAME);
			
			return scanner;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest req, Model model) {
		return "logout";
	}

	private String getOrganizationNameKey(HttpServletRequest req) {
		return stormpathOrganizationNameKeyResolver.get(req, null);
	}
}
