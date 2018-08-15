package be.businesstraining;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import be.businesstraining.domain.Compte;
import be.businesstraining.repository.IComptesRepository;

@SpringBootApplication
public class MyBootApplication {
	
	@Autowired
	private IComptesRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(MyBootApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runIt() {
		return args -> {
			
		//	repo.save(new Compte("D100", "Dave Sayer", new BigDecimal("1500")));
			
			repo
			.findComptesBySoldeGreaterThanEqual(new BigDecimal("1000"))
			.forEach(System.out::println);
			
		};
	}
}
