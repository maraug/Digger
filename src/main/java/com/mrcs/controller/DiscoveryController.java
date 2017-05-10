package com.mrcs.controller;

import com.mrcs.domain.Comment;
import com.mrcs.domain.Discovery;
import com.mrcs.domain.User;
import com.mrcs.service.CommentService;
import com.mrcs.service.DiscoveryService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DiscoveryController", value = "discovery")
public class DiscoveryController extends HttpServlet {

	@Inject
	private DiscoveryService discoveryService;

	@Inject
	private CommentService commentService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long discoveryId = Long.valueOf(request.getParameter("id"));

		Discovery discovery = discoveryService.getDiscoveryById(discoveryId);
		request.setAttribute("discovery", discovery);

		List<Comment> comments = commentService.getDiscoveryComments(discoveryId);
		request.setAttribute("comments", comments);

		request.getRequestDispatcher("WEB-INF/discovery.jsp").forward(request, response);
	}
}
