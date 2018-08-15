package be.businesstraining.client;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import be.businesstraining.AppConfiguration;
import be.businesstraining.model.Employe;

public class Client {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfiguration.class)) {

			
//			  Employe e= ctxt.getBean(Employe.class);
//			  System.out.println("This is your annotated bean : "+e);
			  
			  
//			  Employe e= ctxt.getBean("employe2",Employe.class);
//			  System.out.println("This is your annotated bean : "+e);
			  
			  ((List<Employe>)ctxt.getBean("staff")).forEach(System.out::println);
			
			
		} // close
		
		

	}

}
