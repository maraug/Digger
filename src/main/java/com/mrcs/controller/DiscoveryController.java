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

@WebServlet(name = "DiscoveryController", value = "discovery")
public class DiscoveryController extends HttpServlet {

	@Inject
	private DiscoveryService discoveryService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long discoveryId = Long.valueOf(request.getParameter("id"));

		Discovery discovery = discoveryService.getDiscoveryById(discoveryId);

		request.setAttribute("discovery", discovery);

		request.getRequestDispatcher("WEB-INF/discovery.jsp").forward(request, response);
	}
}
