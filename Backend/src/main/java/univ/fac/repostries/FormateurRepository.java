package univ.fac.repostries;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.fac.enities.Formateur;
import java.util.Optional;


@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long>{

	boolean existsByEmail(String email);
	Optional<Formateur> findByEmail(String email);
	
}
