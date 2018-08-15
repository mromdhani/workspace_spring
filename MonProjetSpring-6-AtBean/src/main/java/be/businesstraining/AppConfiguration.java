package be.businesstraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import be.businesstraining.model.Employe;

@Configuration
@ComponentScan(basePackages="be.businesstraining")
public class AppConfiguration 
{
 
	@Bean     // Producer
	public Employe employe1() {
		return new Employe("ABDELLAH", 3500);
	}
	
	@Bean
	public Employe employe2() {
		return new Employe("Astrid", 3500);
	}
	
	@Bean
	public List<Employe> staff() {
		return Arrays.asList(employe1(), employe2());
	}
}
