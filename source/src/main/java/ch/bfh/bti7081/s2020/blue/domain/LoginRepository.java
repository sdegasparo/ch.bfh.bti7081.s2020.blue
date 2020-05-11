package ch.bfh.bti7081.s2020.blue.domain;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login,String> {
    Optional<Login> findByEmail(String email);
}
