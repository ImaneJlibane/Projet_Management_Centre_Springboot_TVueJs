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
import univ.fac.services.AssistantService;


@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
@RestController
@RequestMapping("/assistant")
public class AssistantController {
		@Autowired
	    private AssistantService assistantService;
		
	    @GetMapping("/all")
	    private List<Assistant> listAssistant(){
	        return assistantService.List();
	    }
	    @GetMapping("/getbyid/{id}")
	    public Assistant findById(@PathVariable Long id) {
	        return assistantService.findById(id);
	    }

	    @PostMapping("/save")
	    private Assistant ajoutAssistant(@RequestBody Assistant assistant){
	        return assistantService.add(assistant);
	    }
	    @PutMapping("/modif/{id}")
	    private Assistant modifierAssistant(@RequestBody Assistant assistant, @PathVariable Long id){
	       
	        return assistantService.update(assistant,id);
	    }
	    @DeleteMapping("/delete/{id}")
	    private HashMap<String, String> deleteAssistant(@PathVariable Long id){
	    	 return assistantService.delete(id);
	    }
}
