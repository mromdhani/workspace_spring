package be.businesstraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import be.businesstraining.model.Employe;
import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class MyBootApplication {

	@Autowired 
	Employe e;
	
	
	
	
	public static void main(String[] args) {
	   SpringApplication.run(MyBootApplication.class, args);
	 
	}
	
	@Bean 
	public CommandLineRunner run() {
		return args -> 	System.out.println(e) ;
	
		
	}
}
