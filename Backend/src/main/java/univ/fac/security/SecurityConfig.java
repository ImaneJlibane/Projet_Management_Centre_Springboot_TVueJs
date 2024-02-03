package univ.fac.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
	return dap;
}

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .securityMatcher("/**")
        .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/formateur/**").permitAll()
                .requestMatchers("/formation/**").permitAll()
                .requestMatchers("/categorie/**").permitAll()
            	.requestMatchers("/entreprise/**").permitAll()
            	.requestMatchers("/assistant/**").permitAll()
            	.requestMatchers("/planifierFormation/**").permitAll()
            	.requestMatchers("/api/etudiants/**").permitAll()
            	.requestMatchers("/admin/**").permitAll()
            .anyRequest().authenticated()
        		).httpBasic(withDefaults());
    return http.build();
}

}
