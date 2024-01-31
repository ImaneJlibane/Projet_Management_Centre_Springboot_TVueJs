package univ.fac.services;

import univ.fac.DTO.UserDTO;
import univ.fac.DTO.LoginDTO;
import univ.fac.enities.AppRole;
import univ.fac.enities.User;
import univ.fac.repostries.UserRepository;
import univ.fac.services.UserlogService;
import univ.fac.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserImpl implements UserlogService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
   
    @Override
    public String addUser(UserDTO userDTO) {
        Set<AppRole> roles = new HashSet<AppRole>(); // Explicitly specify the generic type

        User user = new User(
                userDTO.getId(),
                userDTO.getUsername(),
                this.passwordEncoder.encode(userDTO.getPassword()),
                roles
        );

        userRepository.save(user);

        return user.getUsername();
    }
    
    
    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        User user1 = userRepository.findByUsername(loginDTO.getUsername());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();

            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                List<AppRole> userRoles = user1.getRoles();

                // Assuming user can have multiple roles, loop through them
                for (AppRole role : userRoles) {
                    String roleName = role.getRoleName();

                    // Use equals() for string comparison
                    if (roleName.equals("ROLE_ADMIN")) {
                        return new LoginResponse("Login Success - Admin", true, userRoles);
                    } else if (roleName.equals("ROLE_FORMATEUR")) {
                        return new LoginResponse("Login Success - Formateur", true, userRoles);
                    } else if (roleName.equals("ROLE_ASSISTANT")) {
                        return new LoginResponse("Login Success - Assistant Role", true, userRoles);
                    }
                }

                // If none of the expected roles are found
                return new LoginResponse("Login Success - Unknown Role", true, userRoles);
            } else {
                return new LoginResponse("Password Not Match", false, null);
            }
        } else {
            return new LoginResponse("Username not exists", false, null);
        }
    }
}
