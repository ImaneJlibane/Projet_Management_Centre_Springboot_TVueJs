package univ.fac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import univ.fac.enities.PlanifierFormation;
import univ.fac.services.PlanifierFormationService;
import univ.fac.response.MessageResponse;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
@RestController
@RequestMapping("/planifierFormation")
public class PlanifierFormationController {

    @Autowired
    private PlanifierFormationService planifierFormationService;

    @GetMapping("/all")
    public List<PlanifierFormation> findAll() {
        return planifierFormationService.findAll();
    }

    @GetMapping("/getById/{id}")
    public PlanifierFormation findById(@PathVariable Long id) {
        return planifierFormationService.findById(id);
    }

    @PostMapping("/planifier")
    public ResponseEntity<String> planifierFormation(@RequestBody PlanifierFormation planification) {
        // Perform any additional validation if needed
        planifierFormationService.planifierFormation(planification);
        return ResponseEntity.ok("Formation planifiée avec succès!");
    }

    @PutMapping("update/{id}")
    public MessageResponse update(@PathVariable Long id, @RequestBody PlanifierFormation planification) {
        return planifierFormationService.update(id, planification);
    }

    @DeleteMapping("/delete/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return planifierFormationService.delete(id);
    }

    @GetMapping("/{id}")
    public PlanifierFormation findById(@PathVariable long id) {
        return planifierFormationService.findById(id);
    }
}

