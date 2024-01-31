package univ.fac.controllers;

import univ.fac.DTO.LoginDTO;
import univ.fac.DTO.UserDTO;
import univ.fac.repostries.UserRepository;
import univ.fac.services.UserlogService;
import univ.fac.response.LoginResponse;
import univ.fac.enities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
@RestController
@RequestMapping("/api/users")
public class UserControlleurs {
 
    private Long id;
    private String username;
    private String password;


    
	 
    @Autowired
    private UserlogService userlogService;
    
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginDTO loginDTO) {
        LoginResponse response = userlogService.loginUser(loginDTO);
		return response;
  
    }
    
    
    @Autowired
    private UserRepository userRepository;

    public UserControlleurs() {
    }
 
    public UserControlleurs(long id, String username,String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
 
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    @Override
    public String toString() {
        return "UserControlleurs{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getRoles());
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}