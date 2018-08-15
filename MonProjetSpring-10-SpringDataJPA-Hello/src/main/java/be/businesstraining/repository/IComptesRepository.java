package be.businesstraining.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.businesstraining.domain.Compte;

//@Repository
public interface IComptesRepository 
             extends JpaRepository<Compte, String> {
	
	
	List<Compte> findComptesBySoldeGreaterThanEqual(BigDecimal seuil);
	
	List<Compte> findComptesByProprietaireStartingWith(String template);
	
	
}
