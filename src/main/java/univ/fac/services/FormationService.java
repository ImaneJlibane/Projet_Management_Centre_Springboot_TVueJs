package univ.fac.services;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import univ.fac.enities.Categorie;
import univ.fac.enities.Formation;
import univ.fac.repostries.CategorieRepository;


import univ.fac.repostries.FormationRepository;

@Service
public class FormationService {
	
	@Autowired
	FormationRepository formationRepository;
	
	    @Autowired
	    private CategorieRepository categorieRepository;


	public List<Formation> list() {
        return formationRepository.findAll();
    }
	 
	
	public Formation findById(long id) {
		Formation formation = formationRepository.findById(id).orElse(null);
        return formation;
	}
	
	
    public Formation saveFormation(Long categorieId, Formation formation) {
        Optional<Categorie> categorieOptional = categorieRepository.findById(categorieId);
        if (categorieOptional.isPresent()) {
            Categorie categorie = categorieOptional.get();
            formation.setCategorieFormation(categorie);
            return formationRepository.save(formation);
        } else {
               return null;
        }
    }
   
    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }

    public Formation updateFormation(Long id, Formation updatedFormation) {
        Optional<Formation> existingFormationOptional = formationRepository.findById(id);
        if (existingFormationOptional.isPresent()) {
            Formation existingFormation = existingFormationOptional.get();
            BeanUtils.copyProperties(updatedFormation, existingFormation, "id", "categorieFormation");
            return formationRepository.save(existingFormation);
        } else {
            return null;
        }
    }
   
    




}
