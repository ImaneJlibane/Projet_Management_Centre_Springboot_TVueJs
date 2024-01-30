

	package univ.fac.controllers;

	import java.util.HashMap;
	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import univ.fac.enities.Admin;
import univ.fac.repostries.AdminRepository;



@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")	@RestController
	public class AdminControlleur {
		
		 @Autowired
		    private AdminRepository iadmin;
		 
		 @GetMapping("admin")
		 public String admin() {
		 	return "Page admin";
		 	
		 }
		    @GetMapping("/all")
		    private List<Admin> adminList() {
		        return this.iadmin.findAll();
		    }

		    @PostMapping("/save")
		    private Admin ajouteradmin(@RequestBody Admin admin) {
		        return this.iadmin.save(admin);
		    }

	

	
}
