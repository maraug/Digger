package com.mrcs.controller;

import com.mrcs.service.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "LoginController", value = "login")
public class LoginController extends HttpServlet {

	@Inject
	private UserService userService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			request.login(username, password);

			userService.saveUserInSession(username, request.getSession(true));

			String referer = request.getHeader("Referer");
			String requestPath = request.getContextPath() + referer.substring(referer.lastIndexOf("/"));

			response.sendRedirect(requestPath);
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
