package univ.fac.enities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entreprise {
		  @Id
		  @GeneratedValue(strategy = GenerationType.IDENTITY)
		  private Long id;
		  private String email;
		  private String username;
		  private String password;
		  private String nom;
		  private String ville;
		  private String numeroTel;
}
