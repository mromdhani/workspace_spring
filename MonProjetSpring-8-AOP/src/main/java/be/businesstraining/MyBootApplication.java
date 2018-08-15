package be.businesstraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.businesstraining.service.Calcul;

@SpringBootApplication
public class MyBootApplication {

	@Autowired
	private Calcul calcul;	
	
	public static void main(String[] args) {
		SpringApplication.run(MyBootApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runIt() {  // Exécuté immédiatement après le démarrage du conteneur !
		return args -> 	calcul.additionner(11, 22);		
	}
}
