package be.businesstraining.client;

import java.math.BigDecimal;

import be.businesstraining.domain.Product;

public class App_Without_DI {
	public static void main(String[] args) {
		
		// The client controles the creation on the object
		
		// Drawback : Strong coupling between the client and the object
		Product product = new Product("P1000", "Café", new BigDecimal("5.5"));
		
		System.out.println(product);
		
	}
}
