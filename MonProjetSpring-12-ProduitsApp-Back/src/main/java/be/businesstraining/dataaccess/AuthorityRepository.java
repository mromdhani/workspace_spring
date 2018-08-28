package be.businesstraining.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import be.businesstraining.domain.security.Authority;

public interface AuthorityRepository extends JpaRepository<Authority,Long>{

}
