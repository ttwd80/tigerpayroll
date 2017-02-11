package com.github.ttwd80.tigerpayroll.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@Autowired
	@Qualifier("roleMap")
	Map<String, String> roleMap;

	@RequestMapping(value = "/main")
	public ModelAndView get(final HttpServletRequest request, final HttpServletResponse response) {
		final Set<String> set = roleMap.keySet();
		for (final String role : set) {
			if (request.isUserInRole(role)) {
				final String viewName = roleMap.get(role);
				return new ModelAndView(viewName);
			}
		}
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		return null;
	}
}
