package univ.fac.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import univ.fac.enities.Assistant;
import univ.fac.repostries.AssistantRepository;
import univ.fac.repostries.UserRepository;

@Service
public class AssistantService {

	@Autowired
	AssistantRepository assistantRepository;
	
	  private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(10);



	@Autowired
	UserRepository userRepo;
	
	public List<Assistant> List() {
        return assistantRepository.findAll();
    }

    	 public Assistant add(Assistant assistant) {
 		    UserDetails user = userRepo.findByUsername(assistant.getUsername());
 		    if (user != null) throw new RuntimeException("user already exists");
 		   Assistant appUser = new Assistant();
 		    appUser.setUsername(assistant.getUsername());
 		    appUser.setPassword(bCryptPasswordEncoder.encode(assistant.getPassword()));
 		    appUser.setEmail(assistant.getEmail());
 		    appUser.setDateNaissance(assistant.getDateNaissance());
 		    appUser.setNumeroTel(assistant.getNumeroTel());
 		    appUser.setVille(assistant.getVille());
 		    appUser.setPrenom(assistant.getPrenom());
 		    appUser.setNom(assistant.getNom());
 		    appUser.setRoles(assistant.getRoles());
 		   assistantRepository.save(appUser);
 		    return appUser;

 		  }
  


    public Assistant update( Assistant assistant,  Long id) {
    	Assistant assistant1 = assistantRepository.findById(id).orElse(null);
    	assistant.setId(id);
        if (assistant.getNom() == "") {
        	assistant.setNom(assistant1.getNom());
        }
        if (assistant.getPrenom() == "") {
        	assistant.setPrenom(assistant1.getPrenom());
        }
        if (assistant.getVille() == "") {
        	assistant.setVille(assistant1.getVille());
        }
        if (assistant.getEmail() == "") {
        	assistant.setEmail(assistant1.getEmail());
        }
        if (assistant.getNumeroTel() == "") {
        	assistant.setNumeroTel(assistant1.getNumeroTel());
        }
        if(assistant.getDateNaissance().equals(LocalDate.of(0, 1, 1))){
        	assistant.setDateNaissance(assistant1.getDateNaissance());
        }
        if(assistant.getUsername() == ""){
        	assistant.setUsername(assistant1.getUsername());
        }
        if(assistant.getPassword() == ""){
        	assistant.setPassword(assistant1.getPassword());
        }
        assistant.setRoles(assistant1.getRoles());

        return assistantRepository.saveAndFlush(assistant);
    }


    public HashMap<String, String> delete( Long id) {
        HashMap hashMap = new HashMap();
        try {
        	assistantRepository.deleteById(id);
            hashMap.put("etat", "assistant supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "assistant non supprimer");
            return hashMap;
        }
    }

 
	public Assistant findById(long id) {
		Assistant assistant = assistantRepository.findById(id).orElse(null);
        return assistant;
	}


}
