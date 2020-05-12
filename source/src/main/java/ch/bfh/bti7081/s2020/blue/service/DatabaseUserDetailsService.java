package ch.bfh.bti7081.s2020.blue.service;

import ch.bfh.bti7081.s2020.blue.domain.repository.LoginCrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class DatabaseUserDetailsService implements UserDetailsService {

  private final LoginCrudRepository loginCrudRepository;

  public DatabaseUserDetailsService(LoginCrudRepository loginCrudRepository) {
    this.loginCrudRepository = loginCrudRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    return loginCrudRepository.findById(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found."));
  }
}
