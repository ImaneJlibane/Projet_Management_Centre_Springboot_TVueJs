package univ.fac.repostries;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import univ.fac.enities.PlanifierFormation;

@Repository
public interface PlanifierFormationRepository extends JpaRepository<PlanifierFormation, Long> {
    // You can add custom queries or methods if needed
}

