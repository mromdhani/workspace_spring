package be.businesstraining;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.businesstraining.dataaccess.IProduitsRepository;
import be.businesstraining.domain.Produit;

@SpringBootApplication
public class MyBootApplication {
	
	@Autowired
	private IProduitsRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(MyBootApplication.class, args);
	
	}
	
	@Bean 
	CommandLineRunner runIt() {
	return args -> {
		repo.save(new Produit("A1000", "Disque USB3 1To", new BigDecimal("200.5")));
		repo.save(new Produit("A2000", "Souris Optique", new BigDecimal("10.5")));	
		repo.save(new Produit("A3000", "Ecran LED 21pouces", new BigDecimal("400.5")));	
		};
	}
}
