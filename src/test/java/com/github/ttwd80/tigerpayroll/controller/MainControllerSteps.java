package com.github.ttwd80.tigerpayroll.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

public class MainControllerSteps {

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	Map<String, String> roleLocationMap;

	MainController sut;

	String viewName;

	@Given("a login configuration $adminRole => $adminView, $userRole => $userView")
	public void setUp(final String adminRole, final String adminView, final String userRole, final String userView) {
		roleLocationMap = new LinkedHashMap<>();
		roleLocationMap.put(adminRole, adminView);
		roleLocationMap.put(userRole, userView);
		sut = new MainController(roleLocationMap);
	}

	@When("user is in role $userRole")
	public void userIsInRole(final String userRole) {
		MockitoAnnotations.initMocks(this);
		when(request.isUserInRole(userRole)).thenReturn(Boolean.TRUE);
		final ModelAndView mav = sut.get(request, response);
		viewName = mav.getViewName();
	}

	@Then("the user should see view $view")
	public void theUserShouldSee(final String view) {
		assertThat(viewName, equalTo(view));

	}

}
