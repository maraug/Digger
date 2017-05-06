package com.mrcs.controller;

import com.mrcs.domain.Discovery;
import com.mrcs.service.DiscoveryService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Set;

@WebServlet(name = "HomeController", urlPatterns = "home")
public class HomeController extends HttpServlet {

	@Inject
	DiscoveryService discoveryService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Set<Discovery> discoveries = discoveryService.getAllDiscoveries();

		request.setAttribute("discoveries", discoveries);

		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}
}
