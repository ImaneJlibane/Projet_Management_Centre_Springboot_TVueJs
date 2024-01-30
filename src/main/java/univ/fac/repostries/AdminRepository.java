package univ.fac.repostries;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univ.fac.enities.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}