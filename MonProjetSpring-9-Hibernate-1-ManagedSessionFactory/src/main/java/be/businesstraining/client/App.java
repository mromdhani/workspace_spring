package be.businesstraining.client;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
		// Démarrer le contexte Spring
		ConfigurableApplicationContext ctxt = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		// Obtenir la SessionFactory du contexte Spring
		SessionFactory factory=  ctxt.getBean(SessionFactory.class);
		
		// Obtenir une Session 
		Session session = factory.openSession();
		
		// Utiliser la session pour afficher toutes les données de la table
		Query query = session.createQuery("from Compte c");  // JPA QL
		
		query.getResultList().forEach(System.out::println);
		
		// Clean up
		factory.close();
		ctxt.close();
		
	}
}
