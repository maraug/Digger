package com.mrcs.controller;

import com.mrcs.domain.User;
import com.mrcs.service.VoteService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VoteController", value = "vote")
public class VoteController extends HttpServlet {

	@Inject
	private VoteService voteService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User authenticatedUser = (User) request.getSession().getAttribute("user");
		long discoveryId = Long.parseLong(request.getParameter("discovery_id"));
		String voteType = request.getParameter("vote");
		voteService.processVote(authenticatedUser, discoveryId, voteType);

		response.sendRedirect(request.getContextPath() + "/");
	}
}
