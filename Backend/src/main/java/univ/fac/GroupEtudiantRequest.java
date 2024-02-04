package univ.fac;

import lombok.Data;

import java.util.List;

@Data
public class GroupEtudiantRequest {
    private String groupName;
    private Long etudiantId; // Assuming etudiantId is of type Long
	private List<Long> studentIds;

    // Constructor
    public GroupEtudiantRequest(String groupName, Long etudiantId) {
        this.groupName = groupName;
        this.etudiantId = etudiantId;
    }

    // Getters and setters
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Long etudiantId) {
        this.etudiantId = etudiantId;
    }

    public void setStudentIds(List<Long> studentIds) {
        this.studentIds = studentIds;
    }
}
