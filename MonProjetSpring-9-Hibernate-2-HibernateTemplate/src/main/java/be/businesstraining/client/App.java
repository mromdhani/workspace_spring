package be.businesstraining.client;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.businesstraining.repository.ComptesRepositoryImpl;
import be.businesstraining.repository.IComptesRepository;

public class App {
	public static void main(String[] args) {
		
		// Démarrer le contexte Spring
		ConfigurableApplicationContext ctxt = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		IComptesRepository repo = ctxt.getBean(ComptesRepositoryImpl.class);
		System.out.println(repo.findById("A100"));
		
		
		ctxt.close();
		
	}
}
