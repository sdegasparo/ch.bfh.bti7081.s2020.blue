package ch.bfh.bti7081.s2020.blue.domain.repository;

import ch.bfh.bti7081.s2020.blue.domain.association.patientchallenge.PatientHasChallenge;
import ch.bfh.bti7081.s2020.blue.domain.association.patientchallenge.PatientHasChallengeId;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientHasChallengeCrudRepository extends
    CrudRepository<PatientHasChallenge, PatientHasChallengeId> {

  @Modifying
  @Transactional
  @PreAuthorize("isAuthenticated()")
  @Query(value = "insert into patient_has_challenge"
      + "         (patient_id, challenge_id)"
      + "         values (("
      + "           select id from patient"
      + "             where login_username = :#{principal.username}"
      + "), :#{#challengeId})", nativeQuery = true)
  int assignToCurrentUser(@Param("challengeId") Long challengeId);
}
