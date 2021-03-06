package be.businesstraining.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import be.businesstraining.domain.Compte;
import be.businesstraining.repository.IComptesRepository;

@RestController
@RequestMapping("/comptes")
public class ComptesRestController {
	
	@Autowired
	private IComptesRepository repository;	
	
	// Actions
	//@RequestMapping(value="/comptes", method=RequestMethod.GET)
	@GetMapping("/")                    // Ajouter le trailing / sur l'URL    
	public List<Compte> tous() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Compte> findById(@PathVariable String id) {
		
		 Optional<Compte> resultat =repository.findById(id);
		
		 return (resultat.isPresent())? 
				 new ResponseEntity<>(resultat.get(),HttpStatus.OK)
				 : 
				 new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Compte> addCompte (@RequestBody Compte c) {
		
		 Compte resultat= repository.save(c);
		 return (resultat != null) ?
				 new ResponseEntity<>(resultat, HttpStatus.CREATED)
		         :
		         new ResponseEntity<>(null, HttpStatus.CONFLICT);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Compte> deleteCompte (@PathVariable String id) {
		
		 Optional<Compte> compte = repository.findById(id);
		 if (!compte.isPresent())
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 else {
			 repository.delete(compte.get());
			 return new ResponseEntity<>(HttpStatus.ACCEPTED);
		 }		
	}
	
	@PutMapping("/")
	public ResponseEntity<Compte> updateCompte (@RequestBody Compte c) {
		 Compte resultat = repository.save(c);
		 return new ResponseEntity<Compte>(resultat, HttpStatus.ACCEPTED);		
	}

}
