package be.businesstraining.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import be.businesstraining.domain.Produit;

public interface IProduitsRepository extends JpaRepository<Produit, String> {

}
