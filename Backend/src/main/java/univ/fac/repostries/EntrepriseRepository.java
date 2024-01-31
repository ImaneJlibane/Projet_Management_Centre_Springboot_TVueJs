package univ.fac.repostries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.fac.enities.Entreprise;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long>{

	

}
