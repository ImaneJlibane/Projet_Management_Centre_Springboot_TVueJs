package univ.fac.repostries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.fac.enities.Categorie;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}

