package be.businesstraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.businesstraining.domain.Compte;

public interface IComptesRepository  extends JpaRepository<Compte, String>{

}
