package univ.fac.enities;



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

public class EmploiTemps_F {
	@Id
	  @GeneratedValue(strategy = GenerationType.TABLE)
	  private Long id;
	  private String jour;
	  private String heure_debut;
	  private String heure_fin;

}
