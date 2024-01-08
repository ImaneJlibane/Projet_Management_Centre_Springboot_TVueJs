package univ.fac.enities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Formateur {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String email;
	  private String username;
	  private String password;
	  private String nom;
	  private String prenom;
	  private String ville;
	  private String numeroTel;
	  private Date dateNaissance = new Date();
	  private String specailite;
	  private String NiveauScolair;
	  private String motcle;

	  @OneToMany(mappedBy = "formateur")
	  @JsonIgnore
	  private List<Formation> formationList;
	  @ManyToMany(fetch = FetchType.EAGER)
	  private List<AppRole> roles = new ArrayList<>();
}
