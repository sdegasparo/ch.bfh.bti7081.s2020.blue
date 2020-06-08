package ch.bfh.bti7081.s2020.blue.domain.repository;

import ch.bfh.bti7081.s2020.blue.domain.Login;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentLoginRepositoryImpl implements CurrentLoginRepository {

  public Optional<Login> getCurrentLogin() {
    return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
        .map(Authentication::getPrincipal)
        .map(principal -> (Login) principal);
  }
}
