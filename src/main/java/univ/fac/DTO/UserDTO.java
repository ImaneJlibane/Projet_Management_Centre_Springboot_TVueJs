package univ.fac.DTO;

import java.util.List;
import java.util.Set;

import univ.fac.enities.AppRole;

public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private List<AppRole> roles; // Include roles field

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String password, List<AppRole> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    // Getter methods
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<AppRole> getRoles() {
        return roles;
    }

    // Setter methods
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<AppRole> roles) {
        this.roles = roles;
    }
}
