package com.crossover.ishim.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Maps a URI and resolves to a Thymeleaf template
 * @author Ishim Manon
 *
 */
@Controller
public class AppErrorController implements ErrorController{

	/**
	 * Error Attributes in the Application
	 */
	private ErrorAttributes errorAttributes;
	
	private final static String ERROR_PATH = "/error";

	public ErrorAttributes getErrorAttributes() {
		return errorAttributes;
	}

	public void setErrorAttributes(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	/**
	 * Controller for the Error Controller
	 * @param errorAttributes
	 */
	public AppErrorController(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}
	
	/**
	 * Supports the HTML Error View
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ERROR_PATH, produces = "text/html")
	public ModelAndView errorHtml(HttpServletRequest request, Model model) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		model.addAttribute("errorAtt", this.errorAttributes.getError(requestAttributes));
		return new ModelAndView("/error", getErrorAttributes(request, false));
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

	private Map<String, Object> getErrorAttributes(HttpServletRequest request,
			boolean includeStackTrace) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		return this.errorAttributes.getErrorAttributes(requestAttributes,
				includeStackTrace);
	}
}
