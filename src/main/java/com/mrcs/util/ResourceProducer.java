package com.mrcs.util;


import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ResourceProducer {

	@Produces
	@PersistenceContext(name = "DiggerPU")
	private EntityManager em;

}
