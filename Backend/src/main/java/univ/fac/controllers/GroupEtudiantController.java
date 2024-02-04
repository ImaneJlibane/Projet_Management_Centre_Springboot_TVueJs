package univ.fac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import univ.fac.EntityNotFoundException;
import univ.fac.GroupEtudiantRequest;
import univ.fac.enities.Etudiant;
import univ.fac.enities.GroupEtudiant;
import univ.fac.repostries.EtudiantRepository;
import univ.fac.repostries.GroupEtudiantRepository;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/group")
@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class GroupEtudiantController {

    @Autowired
    private GroupEtudiantRepository groupEtudiantRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping("/welcome")
    public String etudiant() {
        return "Page group";
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveGroup(@RequestBody GroupEtudiantRequest request) {
        try {
            List<Long> studentIds = request.getStudentIds();
            String groupName = request.getGroupName();

            if (studentIds.isEmpty()) {
                return ResponseEntity.badRequest().body("No student IDs provided.");
            }

            List<Etudiant> students = etudiantRepository.findAllById(studentIds);

            if (students.isEmpty()) {
                return ResponseEntity.badRequest().body("No students found with provided IDs.");
            }

            List<GroupEtudiant> groupEtudiants = new ArrayList<>();

            for (Etudiant etudiant : students) {
                GroupEtudiant groupEtudiant = new GroupEtudiant();
                groupEtudiant.setNom(groupName);
                groupEtudiant.setEtudiant(etudiant);
                groupEtudiants.add(groupEtudiant);
            }

            groupEtudiantRepository.saveAll(groupEtudiants);

            return ResponseEntity.ok("Group saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving group: " + e.getMessage());
        }
    }
}






