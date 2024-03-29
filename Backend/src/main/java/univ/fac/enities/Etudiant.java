package univ.fac.enities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String email;
	 
	  private String nom;
	  private String prenom;
	  private String ville;
	  private String numeroTel;
	  private Date dateNaissance = new Date();
	  private String formation;
	  @OneToMany(mappedBy = "user")
	  @JsonIgnore

	  private List<Evaluation> evaluationList;

	
	  

}
