package univ.fac.repostries;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.fac.enities.feedback;


@Repository
public interface feedbackRepository extends JpaRepository<feedback, Long> {
}
