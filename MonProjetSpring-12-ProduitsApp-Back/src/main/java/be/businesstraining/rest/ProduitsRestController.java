package be.businesstraining.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.businesstraining.dataaccess.IProduitsRepository;
import be.businesstraining.domain.Produit;

@RestController
@RequestMapping("/produits")
public class ProduitsRestController {
	
	@Autowired
	private IProduitsRepository repo;
	
	@GetMapping("/")
	public List<Produit> getAll() {
		return repo.findAll();
	}

}
