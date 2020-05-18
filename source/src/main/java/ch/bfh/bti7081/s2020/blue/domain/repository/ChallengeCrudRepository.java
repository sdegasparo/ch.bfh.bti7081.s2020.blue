package ch.bfh.bti7081.s2020.blue.domain.repository;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ChallengeCrudRepository extends CrudRepository<Challenge, Long> {

  @Override
  List<Challenge> findAll();
}
