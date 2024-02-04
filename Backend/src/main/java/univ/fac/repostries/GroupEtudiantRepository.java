package univ.fac.repostries;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.fac.enities.GroupEtudiant;

@Repository
public interface GroupEtudiantRepository extends JpaRepository<GroupEtudiant, Long> {
}
