package univ.fac.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import univ.fac.enities.Formation;

import univ.fac.repostries.FormationRepository;

import univ.fac.services.FormationService;

@CrossOrigin(origins = "http://localhost:8081/")
@RestController
@RequestMapping("/formation")
public class FormationController {

	@Autowired
    private FormationService formationService;
	 @Autowired
	 private FormationRepository formationRepository;
	   @GetMapping("/all")
	   private List<Formation> list() {
	        return formationService.list();
	    }
	   @GetMapping("all/{id}")
	    public ResponseEntity<Formation> getFormationById(@PathVariable Long id) {
	        Formation formation = formationRepository.findById(id)
	                .orElse(null);

	        if (formation != null) {
	            return new ResponseEntity<>(formation, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	    @GetMapping("/findById/{id}")
	    private Formation findById(@RequestBody long id) {
	    	 return formationService.findById(id);
		}


	    @PostMapping("/save/{categorieId}")
	    public Formation saveFormation(@PathVariable Long categorieId, @RequestBody Formation formation) {
	        return formationService.saveFormation(categorieId, formation);
	    }

	    @PutMapping("modif/{id}")
	    public ResponseEntity<Formation> updateFormation(@PathVariable Long id, @RequestBody Formation updatedFormation) {
	        Formation updated = formationService.updateFormation(id, updatedFormation);
	        return (updated != null) ?
	                new ResponseEntity<>(updated, HttpStatus.OK) :
	                new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    @DeleteMapping("delete/{id}")
	    public ResponseEntity<Void> deleteFormation(@PathVariable Long id) {
	        formationService.deleteFormation(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	
	    
}
