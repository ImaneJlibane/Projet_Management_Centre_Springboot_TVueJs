package univ.fac.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import univ.fac.enities.Categorie;
import univ.fac.repostries.CategorieRepository;


@Service
public class CategorieService {
	@Autowired
    private CategorieRepository categorieRepository;
    
    public List<Categorie> list(){
        return categorieRepository.findAll();
    }
  
    public Categorie add( Categorie categorie){
        return this.categorieRepository.save(categorie);
    }
    
    public Categorie update( Categorie categorie,  Long id){
        Categorie categorie1=categorieRepository.findById(id).orElse(null);
        if(categorie.getNomCat()==null){
        	categorie.setNomCat(categorie1.getNomCat());
        }
        categorie.setIdCat(id);
        return categorieRepository.saveAndFlush(categorie);
    }
    
    public HashMap<String, String> delete( Long id){
        HashMap hashMap=new HashMap();
        try {
        	categorieRepository.deleteById(id);
            hashMap.put("etat","formation supprimer");
            return hashMap;
        }catch (Exception e){
            hashMap.put("etat","formation non supprimer");
            return hashMap;
        }
    }

}
