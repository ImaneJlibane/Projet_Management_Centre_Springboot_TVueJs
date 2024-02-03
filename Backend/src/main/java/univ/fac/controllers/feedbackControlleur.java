package univ.fac.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import univ.fac.enities.feedback;
import univ.fac.repostries.feedbackRepository;
@CrossOrigin(origins = "http://localhost:8081/")
//EtudiantController.java
@RestController
@RequestMapping("/api/feedback")
public class feedbackControlleur {

 @Autowired
 private feedbackRepository FeedbackRepository;
 
 @GetMapping("/welcome")

 public String feedback() {
 	return "Page feedback";
 	
 }
  

 @PostMapping("/register")
 public feedback feedbackEtudiant(@RequestBody feedback Feedback) {

		return FeedbackRepository.save(Feedback);
	
 }

 @GetMapping("/all")
 public List<feedback> getAllEtudiants() {
     return FeedbackRepository.findAll();
 }
}
