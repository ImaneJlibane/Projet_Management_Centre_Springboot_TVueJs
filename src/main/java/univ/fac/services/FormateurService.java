package univ.fac.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import univ.fac.enities.AppRole;
import univ.fac.enities.Formateur;
import univ.fac.enities.Formation;
import univ.fac.enities.User;
import univ.fac.repostries.AppRoleRepository;
import univ.fac.repostries.FormateurRepository;
import univ.fac.repostries.UserRepository;
import univ.fac.response.MessageResponse;



@Service

public class FormateurService {
	@Autowired
	  private AppRoleRepository appRoleRepository;
	  private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(10);


	@Autowired
	FormateurRepository formateurRepository;
	@Autowired
	UserRepository userRepo;

	  public void addRoleToUser(String username, String rolename) {
		  User user = userRepo.findByUsername(username);
		  System.out.println("Role Name: " + rolename);
	        AppRole role = appRoleRepository.findByRoleName(rolename);
	        String rule = role.getRoleName();
	        System.out.println("Role Name: " + role);
	        System.out.println("Role nom: " + rolename);
	        System.out.println("Rule: " + rule);
	        // Check if user and role exist
	        if (user == null || role == null) {
	            // Handle the case where user or role is not found
	            throw new RuntimeException("User or role not found");
	        
	        }
	        // Add the role to the user's set of roles
	        user.getRoles().add(role);
	        
	        // Save the updated user (assuming you have a method like saveOrUpdate in your repository)
	        userRepo.save(user);
	  }

	   @Transactional
	 public Formateur saveformateur(Formateur formateur) {
		    UserDetails user = userRepo.findByUsername(formateur.getUsername());
		 
		    if (user != null) throw new RuntimeException("user already exists");
		    Formateur appUser = new Formateur();
		    appUser.setUsername(formateur.getUsername());
		    appUser.setPassword(bCryptPasswordEncoder.encode(formateur.getPassword()));
		    appUser.setSpecailite(formateur.getSpecailite());
		    appUser.setEmail(formateur.getEmail());
		    appUser.setNiveauScolair(formateur.getNiveauScolair());
		    appUser.setDateNaissance(new Date());
		    appUser.setNumeroTel(formateur.getNumeroTel());
		    appUser.setVille(formateur.getVille());
		    appUser.setConfirmPassword(formateur.getConfirmPassword());
		    appUser.setPrenom(formateur.getPrenom());
		    appUser.setNom(formateur.getNom());
		    appUser.setRoles(formateur.getRoles());
		    // addRoleToUser(formateur.getUsername(), "ROLE_FORMATEUR");
		    formateurRepository.save(appUser);
		    return appUser;

		  }
	   @Transactional
	 public User addUser(Formateur formateur) {
	        return formateurRepository.save(formateur);
	    }
	  public AppRole save(AppRole role) {
	    return appRoleRepository.save(role);
	  }

	
	  public UserDetails loadUserByUsername(String username) {
	    return userRepo.findByUsername(username);
	  }

	  
	

    @Transactional
	
	public MessageResponse save(Formateur formateur) {
		boolean existe = formateurRepository.existsByEmail(formateur.getEmail());
        if (existe){
        	return new MessageResponse(false,"Echec !","Ce formateur existe déja !");   
        } else {
        formateurRepository.save(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    public Formateur updateFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }
    
    
    @Transactional
    public MessageResponse update(long id, Formateur formateur) {
    	Formateur existe = findById(id);
        if (existe == null){
        	return new MessageResponse(false,"Echec !","Ce formateur n'existe pas !");   
        } else {
        formateur.setId(id);
        formateurRepository.save(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }

    @Transactional

	public MessageResponse delete(long id)  {
    	Formateur formateur = findById(id);
		if (formateur == null){
        	return new MessageResponse(false,"Echec !","Ce formateur n'existe pas !");   
        } else {
        formateurRepository.delete(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
        }
    }
    
    
    
    public List<Formateur> findAll() {

        return formateurRepository.findAll();
    }


	public Formateur findById(long id) {
		Formateur formateur = formateurRepository.findById(id).orElse(null);
        return formateur;
	}

	public boolean findByEmail(Formateur formateur) {
		boolean existe = formateurRepository.existsByEmail(formateur.getEmail());
	       return existe;
    }
//	public Optional<Formateur> findByEmail(String email) {
//	    return formateurRepository.findByEmail(email);
//	}

	
}
