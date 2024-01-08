package univ.fac.enities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Formation {
	 @Id
	  @GeneratedValue(strategy = GenerationType.TABLE)
	  private Long id;
	  private String nom;
	  private String description;
	  private String motcle;
	  private String horaire;
	  @ManyToMany
	  private List<User> usersList;
	  @ManyToOne
	  private Formateur formateur;
	  

}
