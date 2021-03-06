package com.mrcs.controller;

import com.mrcs.domain.User;
import com.mrcs.service.CommentService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CommentController", value = "comment")
public class CommentController extends HttpServlet {

	@Inject
	private CommentService commentService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String comment = request.getParameter("comment");
		long discoveryId = Long.valueOf(request.getParameter("discoveryId"));
		User author = (User) request.getSession().getAttribute("user");

		commentService.addComment(comment, author, discoveryId);

		//response.sendRedirect((request.getContextPath() + "/discovery?id=") + discoveryId);
		String referer = request.getHeader("Referer");
		String requestPath = request.getContextPath() + referer.substring(referer.lastIndexOf("/"));

		response.sendRedirect(requestPath);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long commentId = Long.valueOf(request.getParameter("comment_id"));
		String action = request.getParameter("action");

		if ("delete".equals(action)) {
			commentService.deleteComment(commentId);
		}

		String referer = request.getHeader("Referer");
		String requestPath = request.getContextPath() + referer.substring(referer.lastIndexOf("/"));

		response.sendRedirect(requestPath);
	}
}
