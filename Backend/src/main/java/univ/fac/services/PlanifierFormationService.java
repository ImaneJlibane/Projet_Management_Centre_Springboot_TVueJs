package univ.fac.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
import java.sql.Date;

import univ.fac.enities.Entreprise;
import univ.fac.enities.Formation;
import univ.fac.enities.PlanifierFormation;
import univ.fac.response.MessageResponse;
import univ.fac.repostries.PlanifierFormationRepository;
import univ.fac.repostries.PlanifierFormationRepository;

@Service
public class PlanifierFormationService {
	@Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private PlanifierFormationRepository planifierFormationRepository;
    @Autowired
    private FormationService formationService;
    

    public List<PlanifierFormation> findAll() {
        return planifierFormationRepository.findAll();
    }

    public PlanifierFormation findById(Long id) {
        return planifierFormationRepository.findById(id).orElse(null);
    }

    public void planifierFormation(PlanifierFormation planification) {
        // Perform any additional business logic or validation if needed
        planifierFormationRepository.save(planification);
    }

    public MessageResponse update(Long id, PlanifierFormation planification) {
        PlanifierFormation existingPlanification = planifierFormationRepository.findById(id).orElse(null);
        if (existingPlanification != null) {
            // Update existing planification with new data
            existingPlanification.setDate(planification.getDate());
            existingPlanification.setFormateur(planification.getFormateur());
            existingPlanification.setEntreprise(planification.getEntreprise());
            existingPlanification.setFormation(planification.getFormation());

            // Save the updated planification
            planifierFormationRepository.save(existingPlanification);

            return new MessageResponse(true, "Planification updated successfully", null); // Fix here
        } else {
            return new MessageResponse(false, "Planification not found", null);
        }
    }

    public MessageResponse delete(Long id) {
        try {
            planifierFormationRepository.deleteById(id);
            return new MessageResponse(true, "Planification deleted successfully", null); // Fix here
        } catch (Exception e) {
            return new MessageResponse(false, "Error deleting planification", e.getMessage());
        }}
    
    
    
    
    
    
    
    
    
    
    
    @Scheduled(cron = "0 0 0 * * *") 
    public void verifierFinFormationEtEnvoyerFormulaire() {
        List<PlanifierFormation> planifications = planifierFormationRepository.findAll();

        for (PlanifierFormation planification : planifications) {
          	 System.out.println("date : " + planification.getDateFin());
            if (planification.getDateFin().after(new Date(0))) {
                try {
               	 System.out.println("date 2: " + planification.getDateFin());
                    envoyerFormulaireFeedback(planification);
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
            }
        }
    }

    private void envoyerFormulaireFeedback(PlanifierFormation planification) {
        Formation formation = planification.getFormation();
     	 System.out.println("formation : " + formation);
        List<Entreprise> entreprises = formation.getEntrelist();
    	 System.out.println("entreprise : " + entreprises);

        String lienFormulaire = generateLienFormulaire();

        for (Entreprise entreprise : entreprises) {
        	 System.out.println("Entreprise ID: " + entreprise.getId());
             System.out.println("Entreprise email: " + entreprise.getEmail());
            String sujetEntreprise = "Formulaire de Feedback pour la formation";
            String contenuEntreprise = "Bonjour " + entreprise.getNom() + ",\n\n" +
                                        "Merci de remplir le formulaire de feedback pour la formation.\n" +
                                        "Cliquez sur le lien suivant pour accéder au formulaire: " + lienFormulaire + "\n\n" +
                                        "Cordialement,\nVotre équipe de formation";

            envoyerEmail(entreprise.getEmail(), sujetEntreprise, contenuEntreprise);
        }
    }
    
    private void envoyerEmail(String destinataire, String sujet, String contenu) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(destinataire);
        message.setSubject(sujet);
        message.setText(contenu);

        javaMailSender.send(message);
    }

    private String generateLienFormulaire() {

        return "http://localhost:8081/AdminDashboard";
    }
}

