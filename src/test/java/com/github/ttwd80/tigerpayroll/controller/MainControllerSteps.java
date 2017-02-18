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
import org.jbehave.core.model.ExamplesTable;
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

	ModelAndView mav;

	@Given("login configuration: $table")
	public void setUp(final ExamplesTable table) {
		roleLocationMap = new LinkedHashMap<>();
		for (final Map<String, String> row : table.getRows()) {
			roleLocationMap.put(row.get("role"), row.get("view"));
		}
		sut = new MainController(roleLocationMap);
	}

	@When("user is in role $userRole")
	public void userIsInRole(final String userRole) {
		MockitoAnnotations.initMocks(this);
		when(request.isUserInRole(userRole)).thenReturn(Boolean.TRUE);
		mav = sut.get(request, response);
	}

	@Then("the user should see view $view")
	public void theUserShouldSee(final String view) {
		assertThat(mav.getViewName(), equalTo(view));
	}

	@Then("the user should see a permission error")
	public void theUserShouldSeePermissionError() {
		assertThat(mav, nullValue());
		verify(response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}

}
