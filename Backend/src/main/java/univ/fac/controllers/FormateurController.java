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



import univ.fac.enities.Formateur;
import univ.fac.services.FormateurService;
import univ.fac.response.MessageResponse;




@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
@RestController
@RequestMapping("/formateur")

public class FormateurController {

	@Autowired
    private FormateurService formateurService;
	@GetMapping()
	public String admin() {
		return "Page formateur";
	}
	
	@GetMapping("/all")
    public List<Formateur> findAll() {
        return formateurService.findAll();
    }
	 @GetMapping("/getbyid/{id}")
	    public Formateur findById(@PathVariable Long id) {
	        return formateurService.findById(id);
	    }
	
	 @PostMapping("/save")
	    private Formateur ajouterformateur(@RequestBody Formateur formateur) {
		 return formateurService.saveformateur(formateur);
	    }
	 @PostMapping("/add")
	    public ResponseEntity<String> addUser(@RequestBody  Formateur formateur) {
	        // Perform any additional validation if needed
		 formateurService.addUser(formateur);
	        return ResponseEntity.ok("User added successfully");
	    }

    @PutMapping("/{id}")
    public MessageResponse update(@PathVariable int id, @RequestBody Formateur formateur) {
    	return formateurService.update(id, formateur);
    }

    @PutMapping("/modif/{id}")
        public ResponseEntity<Formateur> updateFormateur(@RequestBody Formateur formateur) {
        Formateur update = formateurService.updateFormateur(formateur);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public MessageResponse delete(@PathVariable int id) {
    	return formateurService.delete(id);
    }
    
    @GetMapping("/{id}")
    public Formateur findById(@PathVariable long id) {
        return formateurService.findById(id);
    }
    
}
