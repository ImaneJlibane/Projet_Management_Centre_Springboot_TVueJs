package univ.fac.enities;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  

@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Formateur")
public class Formateur extends User {
	  private String email;
	  private String nom;
	  private String prenom;
	  private String ville;
	  private String numeroTel;
	  private Date dateNaissance = new Date();
	  private String specailite;
	  private String niveauScolair;
	  private String confirmPassword;
	  private String motcle;
	  private String remarques;

	  @OneToMany(mappedBy = "formateur")
	  @JsonIgnore
	  private List<Formation> formationList;

}
