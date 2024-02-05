package univ.fac.enities;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String titre;
	  private String image;
	  private String description;
	  private String objectifs;
	  private String ville;
	  private int nbHeure;
	  private Date dateDebut ;
	  private Date dateFin;
	  private String motcle;
	  private String horaire;
	  private double bugdet;
	  @ManyToOne
	  private Categorie categorieFormation;
	  @ManyToMany
	  private List<GroupEtudiant> usersList;
	  @ManyToOne
	  private Formateur formateur;
	  @ManyToMany
	  private List<Entreprise> entrelist;
	  
	  @Override
	  public String toString() {
	      return "Formation{" +
	              "id=" + id +
	              ", titre='" + titre + '\'' +
	              ", image='" + image + '\'' +
	              ", description='" + description + '\'' +
	              ", objectifs='" + objectifs + '\'' +
	              ", ville='" + ville + '\'' +
	              ", nbHeure=" + nbHeure +
	              ", dateDebut=" + dateDebut +
	              ", dateFin=" + dateFin +
	              ", bugdet=" + bugdet +
	              ", categorieFormation=" + (categorieFormation != null ? categorieFormation.getIdCat() : null) +
	              ", usersList=" + usersList +
	              ", formateur=" + (formateur != null ? formateur.getId() : null) +
	              ", entrelist=" + entrelist +
	              '}';
	  }

	

	public Formation(Date dateFin) {
        this.dateFin = dateFin;
       
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
    public List<Etudiant> getEtudiantList() {
        return usersList.stream()
                .map(GroupEtudiant::getEtudiant)
                .collect(Collectors.toList());
    }
}

