package univ.fac.enities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assistant {
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
	  @ManyToMany(fetch = FetchType.EAGER)
	  private List<AppRole> roles = new ArrayList<>();
}
