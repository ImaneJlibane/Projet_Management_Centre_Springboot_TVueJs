package univ.fac.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.fac.enities.Assistant;
import univ.fac.enities.Entreprise;
import univ.fac.repostries.EntrepriseRepository;


@Service
public class EntrepriseService {
	@Autowired
    private EntrepriseRepository entrepriseRepository;

    
    public List<Entreprise> entrepriseList(){
        return entrepriseRepository.findAll();
    }
   
    public Entreprise add( Entreprise entroprise){

        return entrepriseRepository.save(entroprise);
    }
   
    public Entreprise update( Entreprise entroprise , Long id){
    	Entreprise entre =entrepriseRepository.findById(id).orElse(null);
    	entroprise.setId(id);

        if(entroprise.getUsername() == ""){
        	entroprise.setNom(entre.getUsername());
       }
        if(entroprise.getPassword() == ""){
        	entroprise.setPassword(entre.getPassword());
        }
       if(entroprise.getNom() == ""){
    	   entroprise.setNom(entre.getNom());
        }
       if(entroprise.getAdresse() == ""){
    	   entroprise.setAdresse(entre.getAdresse());
       }
        if(entroprise.getEmail() ==" "){
        	entroprise.setEmail(entre.getEmail());
       }
        if(entroprise.getNumeroTel() ==" "){
        	entroprise.setNumeroTel(entre.getNumeroTel());
       }
        if(entroprise.getUrl() ==" "){
        	entroprise.setUrl(entre.getUrl());
       }
     
        return entrepriseRepository.saveAndFlush(entroprise);
    }

    public HashMap<String, String> delete( Long id){
        HashMap hashMap=new HashMap();
        try{
        	entrepriseRepository.deleteById(id);
            hashMap.put("etat","entreprise supprimer");
            return  hashMap;
        }
        catch (Exception e){
            hashMap.put("etat","entreprise non supprimer");
            return hashMap;
        }
    }


	public Entreprise findById(long id) {
		Entreprise entreprise = entrepriseRepository.findById(id).orElse(null);
        return entreprise;
	}

    
}
