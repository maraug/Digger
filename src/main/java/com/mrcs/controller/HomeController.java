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
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = "home")
public class HomeController extends HttpServlet {

	@Inject
	private DiscoveryService discoveryService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Discovery> discoveries = discoveryService.getAllDiscoveries();

		request.setAttribute("discoveries", discoveries);

		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}
}
