package univ.fac.enities;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Categorie {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long idCat;
	  private String nomCat;

	  @OneToMany(mappedBy = "categorieFormation")
	  @JsonIgnore
	  private List<Formation> formations;
	  @Override
	  public String toString() {
	      return "Categorie{" +
	              "idCat=" + idCat +
	              ", nomCat='" + nomCat + '\'' +
	              '}';
	  }

}
