package com.mrcs.service;


import com.mrcs.domain.Comment;
import com.mrcs.domain.User;
import com.mrcs.repository.CommentRepository;

import javax.inject.Inject;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class CommentService {

	private CommentRepository repository;

	private DiscoveryService discoveryService;

	@Inject
	public CommentService(CommentRepository repository, DiscoveryService discoveryService) {
		this.repository = repository;
		this.discoveryService = discoveryService;
	}

	public void addComment(String content, User author, long discoveryId) {

		Comment comment = new Comment();
		comment.setAuthor(author);
		comment.setContent(content);
		comment.setTimestamp(new Date());
		comment.setDiscovery(discoveryService.getDiscoveryById(discoveryId));

		repository.save(comment);
	}

	public List<Comment> getDiscoveryComments(long discoveryId) {
		List<Comment> comments = repository.getCommentsByDiscoveryId(discoveryId);
		if (comments != null) {
			comments.sort(Comparator.comparing(Comment::getTimestamp));
		}
		return comments;
	}

	public void deleteComment(Long commentId) {
		repository.deleteComment(commentId);
	}
}
