package be.businesstraining.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.businesstraining.dataaccess.IProduitsRepository;
import be.businesstraining.domain.Produit;

@RestController
@RequestMapping("/produits")
@CrossOrigin(origins="*") // CROSS pour tout le monde !
public class ProduitsRestController {
	
	@Autowired
	private IProduitsRepository repo;
	
	@GetMapping(value= {"", "/"})
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public List<Produit> getAll() {
		return repo.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Produit> getProduitById(@PathVariable String id) {
		
		Optional<Produit> result = repo.findById(id);
		 
		 return (result.isPresent())? 
				   new ResponseEntity<>(result.get(), HttpStatus.OK)
				   :
				   new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public void addProduit( @RequestBody Produit p) {
		 repo.save(p);
	}

}
