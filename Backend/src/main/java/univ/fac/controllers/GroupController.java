package univ.fac.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import univ.fac.enities.Etudiant;
import univ.fac.enities.GroupEtudiant;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @PostMapping("/Add")
    public ResponseEntity<GroupEtudiant> createGroup(@RequestBody GroupEtudiant group) {
        // You may want to add additional validation or business logic here
        entityManager.persist(group);
        return new ResponseEntity<>(group, HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping("/{groupId}/addStudent")
    public ResponseEntity<Void> addStudentToGroup(@PathVariable Long groupId, @RequestBody Etudiant student) {
        GroupEtudiant group = entityManager.find(GroupEtudiant.class, groupId);

        if (group != null) {
            // You may want to add additional validation or business logic here

            // Set the group for the student using the GroupEtudiant setEtudiant method
            group.setEtudiant(student);

            // Save the updated group
            entityManager.persist(group);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GroupEtudiant> getGroup(@PathVariable Long groupId) {
        GroupEtudiant group = entityManager.find(GroupEtudiant.class, groupId);

        if (group != null) {
            return new ResponseEntity<>(group, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<GroupEtudiant>> getAllGroups() {
        List<GroupEtudiant> groups = entityManager.createQuery("SELECT g FROM GroupEtudiant g", GroupEtudiant.class)
                .getResultList();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    // Add additional methods as needed
}
