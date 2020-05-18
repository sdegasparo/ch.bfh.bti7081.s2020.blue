package ch.bfh.bti7081.s2020.blue.domain.repository;

import ch.bfh.bti7081.s2020.blue.domain.Login;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface LoginCrudRepository extends CrudRepository<Login, String> {

  Optional<Login> findByEmail(String email);
}
