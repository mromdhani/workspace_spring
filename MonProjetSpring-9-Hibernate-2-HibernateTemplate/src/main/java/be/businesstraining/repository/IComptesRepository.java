package be.businesstraining.repository;

import be.businesstraining.domain.Compte;

public interface IComptesRepository {
	
	//CRUD
	void create(Compte c);
	Compte findById(String id);

}
