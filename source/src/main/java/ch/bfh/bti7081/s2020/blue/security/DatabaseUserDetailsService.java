package ch.bfh.bti7081.s2020.blue.security;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ch.bfh.bti7081.s2020.blue.model.User;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    return Arrays.asList(
        new User("john", passwordEncoder.encode("john")),
        new User("peter", passwordEncoder.encode("john"))
    )
        .stream()
        .filter(u -> u.getUsername().equals(username))
        .findFirst()
        .orElseThrow(() -> new UsernameNotFoundException("User not found."));

  }
}