package univ.fac.response;

import java.util.List;
import java.util.Set;

import univ.fac.enities.AppRole;

public class LoginResponse {
    private String message;
    private Boolean status;
    private List<AppRole> roles; 


    public LoginResponse(String message, Boolean status, List<AppRole> userRoles) {
        this.message = message;
        this.status = status;
        this.roles = userRoles;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    public List<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AppRole> roles) {
        this.roles = roles;
    }


}







