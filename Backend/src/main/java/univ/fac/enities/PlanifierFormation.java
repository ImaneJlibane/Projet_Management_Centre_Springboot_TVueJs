package univ.fac.enities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class PlanifierFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private Formateur formateur;

    @ManyToOne
    private Entreprise entreprise;

    @ManyToOne
    private Formation formation;

    // Constructeurs, getters, setters, etc.

    public PlanifierFormation() {
    }

    public PlanifierFormation(Date date, Formateur formateur, Entreprise entreprise, Formation formation) {
        this.date = date;
        this.formateur = formateur;
        this.entreprise = entreprise;
        this.formation = formation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Date getDateFin() {
        return this.formation.getDateFin();
    }
    
}
