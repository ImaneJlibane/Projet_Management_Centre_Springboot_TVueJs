package univ.fac.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import univ.fac.enities.Assistant;
import univ.fac.enities.Entreprise;

import univ.fac.services.EntrepriseService;

@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
@RestController
@RequestMapping("/entreprise")


public class EntrepriseController {
	@Autowired
    private EntrepriseService entrepriseService;
    
	  @GetMapping("/all")
	    private List<Entreprise> entrepriseList(){
	        return entrepriseService.entrepriseList();
	    }
	  @GetMapping("/getbyid/{id}")
	    public Entreprise findById(@PathVariable Long id) {
	        return entrepriseService.findById(id);
	    }
	    @PostMapping("/save")
	    private Entreprise ajoutercandidat(@RequestBody Entreprise entreprise){

	        return entrepriseService.add(entreprise);
	    }
	    @PutMapping("/modif/{id}")
	    private Entreprise modifercandidat(@RequestBody Entreprise entreprise , @PathVariable Long id){
	        return entrepriseService.update(entreprise,id);
	    }
	    @DeleteMapping("delete/{id}")
	    private HashMap<String, String> deletecandidat(@PathVariable Long id){
	    	return entrepriseService.delete(id);
	    }
	   
}
