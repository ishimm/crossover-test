package com.stormpath.idsite_demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.servlet.account.AccountResolver;
import com.stormpath.sdk.servlet.http.Resolver;

@Controller
public class RestrictedController {

	@Autowired
    Application app;
	
	@Value("#{ @environment['stormpath.sso.cross.link'] ?: '/' }")
	private String crossLink;

	@Value("#{ @environment['stormpath.sso.message.primary'] ?: 'Primary' }")
	private String messagePrimary;

	@Value("#{ @environment['stormpath.sso.message.secondary'] ?: 'Secondary' }")
	private String messageSecondary;

	@Autowired
	Resolver<String> stormpathOrganizationNameKeyResolver;

	@RequestMapping("/restricted/user")
	public String restricted(HttpServletRequest req, Model model) {
		Account account = (Account) req.getAttribute("account");
		if(account == null){
			account = AccountResolver.INSTANCE.getAccount(req);
		}
		model.addAttribute("appName", app.getName());
		model.addAttribute("crossLink", crossLink);
		model.addAttribute("messagePrimary", messagePrimary);
		model.addAttribute("messageSecondary", messageSecondary);

		if (account != null) {
			String org = getOrganizationNameKey(req);
			if (org != null && account.getApplications().getSize() > 1) {
				model.addAttribute("crossLink", "//" + org + "." + crossLink);
			}
			String templateSuffix = (org == null) ? "user" : org;
			return "restricted/" + templateSuffix;
		} else 
			return "redirect:/login";
	}

	private String getOrganizationNameKey(HttpServletRequest req) {
		return stormpathOrganizationNameKeyResolver.get(req, null);
	}
}
