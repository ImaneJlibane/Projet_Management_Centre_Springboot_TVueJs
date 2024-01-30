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

import univ.fac.enities.Categorie;
import univ.fac.services.CategorieService;
@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
@RestController
@RequestMapping("/categorie")
public class Categoriecontroller {
	@Autowired
    private CategorieService categorieService;
	
    @GetMapping("/all")
    private List<Categorie> listCategorie(){
        return categorieService.list();
    }
    @PostMapping("/save")
    private Categorie ajoutCategorie(@RequestBody Categorie categorie){
        return categorieService.add(categorie);
    }
    @PutMapping("/modif/{id}")
    private Categorie modifierCategorie(@RequestBody Categorie categorie, @PathVariable Long id){
       
        return categorieService.update(categorie,id);
    }
    @DeleteMapping("/delete/{id}")
    private HashMap<String, String> deleteCategorie(@PathVariable Long id){
    	 return categorieService.delete(id);
    }

}
