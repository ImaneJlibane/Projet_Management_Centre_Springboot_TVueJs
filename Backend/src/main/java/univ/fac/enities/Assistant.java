package univ.fac.enities;


import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Assistant")
public class Assistant extends User {
	 
	  private String email;
	  private String nom;
	  private String prenom;
	  private String ville;
	  private String numeroTel;
	  private Date dateNaissance = new Date();
	  
}
