package univ.fac.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import univ.fac.UserService;

@Configuration
public class SecurityConfig {
@Autowired UserService userService;

@Bean
public PasswordEncoder encoder() {
	return new BCryptPasswordEncoder();
}

@Bean
public DaoAuthenticationProvider daoAuthenticationProvider() {
	DaoAuthenticationProvider dap=new DaoAuthenticationProvider();
	dap.setUserDetailsService((UserDetailsService) userService);
	dap.setPasswordEncoder(encoder());
	dap.setPostAuthenticationChecks((UserDetails userDetails) -> {
	        System.out.println("User authorities: " + userDetails.getAuthorities());
	    });
	return dap;
}

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .securityMatcher("/**")
        .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/formateur/**").hasRole("Admin")
                .requestMatchers("/formation/**").hasRole("Admin")
                .requestMatchers("/categorie/**").hasRole("Admin")
            	.requestMatchers("/entreprise/**").hasAnyRole("Admin","Assistant")
            	.requestMatchers("/assistant/**").hasRole("Admin")
            	.requestMatchers("/planifierFormation/**").hasAnyRole("Admin","Assistant")
            
            	.requestMatchers("/api/etudiants/**").hasRole("Admin")
            	.requestMatchers("/api/group/**").hasRole("Admin")
            	.requestMatchers("/api/feedback/**").hasRole("Admin")
            .anyRequest().authenticated()
        		).httpBasic(withDefaults());
    return http.build();
}

}
