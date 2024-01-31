package univ.fac.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import univ.fac.enities.PlanifierFormation;
import univ.fac.response.MessageResponse;
import univ.fac.repostries.PlanifierFormationRepository;


import java.util.List;

@Service
public class PlanifierFormationService {

    @Autowired
    private PlanifierFormationRepository planifierFormationRepository;

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
}

