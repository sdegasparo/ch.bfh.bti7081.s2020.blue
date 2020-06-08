package ch.bfh.bti7081.s2020.blue.domain.repository;

import ch.bfh.bti7081.s2020.blue.domain.Login;
import java.util.Optional;

public interface CurrentLoginRepository {

  Optional<Login> getCurrentLogin();
}
