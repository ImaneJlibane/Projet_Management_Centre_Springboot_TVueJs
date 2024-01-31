package univ.fac.repostries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.fac.enities.Assistant;



@Repository
public interface AssistantRepository extends JpaRepository<Assistant, Long>{

	List<Assistant> findAll();

	

}
