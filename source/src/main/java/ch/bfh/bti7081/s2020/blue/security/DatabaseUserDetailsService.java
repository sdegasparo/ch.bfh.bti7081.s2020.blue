package ch.bfh.bti7081.s2020.blue.security;

import ch.bfh.bti7081.s2020.blue.domain.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class DatabaseUserDetailsService implements UserDetailsService {
  @Autowired
  private LoginRepository loginRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    return loginRepository.findById(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found."));
  }
}