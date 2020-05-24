package ch.bfh.bti7081.s2020.blue.domain.repository;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeCrudRepository extends CrudRepository<Challenge, Long> {

  @Override
  List<Challenge> findAll();

  @PreAuthorize("isAuthenticated()")
  @Query("select c"
      + " from Challenge c"
      + "         join PatientHasChallenge phc on c.id = phc.challenge.id"
      + "         join Patient p on phc.patient.id = p.id"
      + " where p.login.username = :#{principal.username}")
  List<Challenge> findAllAssignedToCurrentUser();
}
