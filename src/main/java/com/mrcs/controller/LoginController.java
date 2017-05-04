package com.mrcs.controller;

import com.mrcs.service.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

@WebServlet(name = "LoginController", value = "login")
public class LoginController extends HttpServlet {

	@Inject
	private UserService userService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Boolean rememberMe = Boolean.valueOf(request.getParameter("rememberMe"));

		try {
			request.login(username, password);
			if (rememberMe) {
				Cookie cookie = userService.createUserCookie(username);
				response.addCookie(cookie);
			}
			response.sendRedirect("home");
		} catch (ServletException e) {
			response.sendRedirect("login");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getUserPrincipal() == null) {
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		} else {
			response.sendRedirect("home");
		}
	}
}
