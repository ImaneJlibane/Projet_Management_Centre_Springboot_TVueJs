package univ.fac.services;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import univ.fac.enities.Etudiant;
import univ.fac.repostries.EtudiantRepository;
@Service
public class EtudiantService {
 
    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Transactional
    public List<Etudiant> getAllEtudiantsOrderByFormation() {
        
        return etudiantRepository.findAllByOrderByFormation();
    }
    
}
