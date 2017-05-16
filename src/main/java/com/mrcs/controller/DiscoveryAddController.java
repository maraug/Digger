package com.mrcs.controller;

import com.mrcs.domain.User;
import com.mrcs.service.DiscoveryService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscoveryAddController", value = "add")
public class DiscoveryAddController extends HttpServlet {

	@Inject
	private DiscoveryService discoveryService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("inputName");
		String url = request.getParameter("inputUrl");
		String description = request.getParameter("inputDescription");
		User authenticatedUser = (User) request.getSession().getAttribute("user");

		discoveryService.addDiscovery(name, url, description, authenticatedUser);

		response.sendRedirect(request.getContextPath() + "/");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/new.jsp").forward(request,response);
	}
}
