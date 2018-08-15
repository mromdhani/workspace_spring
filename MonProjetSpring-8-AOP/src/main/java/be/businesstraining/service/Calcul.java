package be.businesstraining.service;

import org.springframework.stereotype.Component;

@Component
public class Calcul {
	
	public void additionner(int a, int b) {
		int resultat = a+b;
		System.out.println(a + " + "+ b + " = "+ resultat);
	}

}
