package univ.fac.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import univ.fac.enities.Etudiant;
import univ.fac.repostries.EtudiantRepository;
@CrossOrigin(origins = "http://localhost:8081/")
//EtudiantController.java
@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

 @Autowired
 private EtudiantRepository etudiantRepository;
 
 @GetMapping("/welcome")

 public String etudiant() {
 	return "Page Etudiant";
 	
 }
  

 @PostMapping("/register")
 public Etudiant registerEtudiant(@RequestBody Etudiant etudiant) {
     return etudiantRepository.save(etudiant);
 }

 @GetMapping("/all")
 public List<Etudiant> getAllEtudiants() {
     return etudiantRepository.findAll();
 }
}


