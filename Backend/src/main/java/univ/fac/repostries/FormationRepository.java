package univ.fac.repostries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.fac.enities.Categorie;
import univ.fac.enities.Formation;
import java.util.List;
import java.util.Date;




@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
	
	List<Formation> findByCategorieFormation(Categorie categorieFormation);
	List<Formation> findByVille(String ville);
	List<Formation> findByDateDebut(Date dateDebut);
	
	

}

