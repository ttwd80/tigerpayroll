package com.github.ttwd80.tigerpayroll.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

public class MainControllerTest {

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAdmin() {
		final MainController sut = new MainController();
		final Map<String, String> map = new LinkedHashMap<>();
		map.put("ROLE_ADMIN", "redirect:/aaa");
		map.put("ROLE_USER", "redirect:/bbb");
		sut.roleLocationMap = map;
		when(request.isUserInRole("ROLE_ADMIN")).thenReturn(Boolean.TRUE);
		final ModelAndView mav = sut.get(request, null);
		assertEquals("redirect:/aaa", mav.getViewName());
	}

	@Test
	public void testGetUser() {
		final MainController sut = new MainController();
		final Map<String, String> map = new LinkedHashMap<>();
		map.put("ROLE_ADMIN", "redirect:/aaa");
		map.put("ROLE_USER", "redirect:/bbb");
		sut.roleLocationMap = map;
		when(request.isUserInRole("ROLE_USER")).thenReturn(Boolean.TRUE);
		final ModelAndView mav = sut.get(request, null);
		assertEquals("redirect:/bbb", mav.getViewName());
	}

	@Test
	public void testGetNone() {
		final MainController sut = new MainController();
		final Map<String, String> map = new LinkedHashMap<>();
		map.put("ROLE_ADMIN", "redirect:/aaa");
		map.put("ROLE_USER", "redirect:/bbb");
		sut.roleLocationMap = map;
		final ModelAndView mav = sut.get(request, response);
		assertNull(mav);
		Mockito.verify(response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}

}
