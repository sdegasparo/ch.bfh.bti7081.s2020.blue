package ch.bfh.bti7081.s2020.blue.domain.repository;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeCrudRepository extends CrudRepository<Challenge, Long> {

  @PreAuthorize("isAuthenticated()")
  @Query("select c"
      + " from Challenge c"
      + "         left join PatientHasChallenge phc on c.id = phc.challenge.id"
      + " where phc.patient.login.username = :#{principal.username}")
  List<Challenge> findAllInclusiveAccepted();

  @PreAuthorize("isAuthenticated()")
  @Query("select c"
      + " from Challenge c"
      + "         join PatientHasChallenge phc on c.id = phc.challenge.id"
      + " where phc.completed = false"
      + " and phc.patient.login.username = :#{principal.username}")
  List<Challenge> findAllAssignedToCurrentUserAndNotCompleted();
}
