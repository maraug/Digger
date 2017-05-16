package com.mrcs.repository;

import com.mrcs.domain.Comment;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CommentRepository {

	private EntityManager em;

	@Inject
	public CommentRepository(EntityManager em) {
		this.em = em;
	}

	public CommentRepository() {
	}


	public void save(Comment comment) {
		em.persist(comment);
	}

	public List<Comment> getCommentsByDiscoveryId(long discoveryId) {
		TypedQuery<Comment> query = em.createNamedQuery(Comment.FIND_BY_DISCOVERY_ID, Comment.class);
		query.setParameter("discoveryId", discoveryId);
		List<Comment> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}
		return results;
	}

	public void deleteComment(Long commentId) {
		Comment commentToDelete = em.find(Comment.class, commentId);
		em.remove(commentToDelete);
	}
}
