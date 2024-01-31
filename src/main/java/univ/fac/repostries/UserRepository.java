package univ.fac.repostries;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import univ.fac.enities.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findOneByUsernameAndPassword(String username, String password);
    
public User findByUsername(String username);
}

