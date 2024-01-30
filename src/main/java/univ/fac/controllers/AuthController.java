package univ.fac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import univ.fac.enities.Formateur;
import univ.fac.services.FormateurService;

public class AuthController {
	@Autowired
    private FormateurService formateurService;
	
	
	@PostMapping("/register")
    public String registerProfessor(@ModelAttribute("professor") Formateur formateur) {
        // Add validation and error handling if needed

        // Check if the email is already registered
        if (formateurService.findByEmail(formateur) ){
            // Handle duplicate email
            return "redirect:/register?error";
        }

        // Save the professor
        formateurService.save(formateur);

        // Redirect to a success page or login page
        return "redirect:/login?success";
    }

}
