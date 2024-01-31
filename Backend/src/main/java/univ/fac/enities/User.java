package univ.fac.enities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.DiscriminatorType;



@NoArgsConstructor @AllArgsConstructor @Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)

public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;
String username;
String password;
boolean active=true;
@ManyToMany(fetch = FetchType.EAGER)
private List<AppRole> roles = new ArrayList<>();

public User(Long id, String username, String password, Set<AppRole> roles) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.roles = (List<AppRole>) roles;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    this.getRoles().forEach(appRole -> {
        String roleName = appRole.getRoleName(); // Replace 'getRoleName()' with the actual method in your AppRole entity
        authorities.add(new SimpleGrantedAuthority(roleName));
    });
    return authorities;
}

@Override
public boolean isAccountNonExpired() {return true;}
@Override
public boolean isAccountNonLocked() {return true;}
@Override
public boolean isCredentialsNonExpired() {return true;}
@Override
public boolean isEnabled() {return this.active;}
}
