package be.businesstraining.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import be.businesstraining.domain.Compte;


public class ComptesRepositoryImpl implements IComptesRepository {

	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public void create(Compte c) {
		template.save(c);
		
	}

	@Override
	public Compte findById(String id) {
	
		return template.get(Compte.class, id);
	}
	
	
//	private SessionFactory factory;
//	
//	public SessionFactory getFactory() {
//		return factory;
//	}
//
//	public void setFactory(SessionFactory factory) {
//		this.factory = factory;
//		
//		
//	}
//
//	@Override
//	public void create(Compte c) {
//		
//	}
//
//	@Override
//	public Compte findById(String id) {
//		Session session = factory.openSession();		
//		return session.get(Compte.class, id);
//	}

}
