package univ.fac.services;
import univ.fac.DTO.UserDTO;
import univ.fac.DTO.LoginDTO;
import univ.fac.response.LoginResponse;

public interface UserlogService {
    String addUser(UserDTO UserDTO);

   LoginResponse loginUser(LoginDTO loginDTO);


}