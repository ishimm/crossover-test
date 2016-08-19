package com.crossover.ishim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stormpath.sdk.application.Application;

/**
 * Maps a URI and resolves to a Thymeleaf template
 * @author Ishim Manon
 *
 */
@Controller
public class HomeController {
    @Autowired
    Application app;

    @RequestMapping("/")
    public String home(Model model) {
        return "/index";
    }
    
    @RequestMapping("/index")
    public String index(Model model) {
    	model.addAttribute("appName", app.getName());
        model.addAttribute("appDescription", app.getDescription());
        return "index";
    }
    
	@RequestMapping("/chooseLogin")
	public String chooseLogin(Model model){
		return "chooseLogin";
	}
}
