package ch.bfh.bti7081.s2020.blue.service;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import ch.bfh.bti7081.s2020.blue.domain.repository.ChallengeCrudRepository;
import ch.bfh.bti7081.s2020.blue.domain.repository.PatientHasChallengeCrudRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {

  private ChallengeCrudRepository challengeCrudRepository;
  private PatientHasChallengeCrudRepository patientHasChallengeCrudRepository;

  public ChallengeService(ChallengeCrudRepository challengeCrudRepository,
      PatientHasChallengeCrudRepository patientHasChallengeCrudRepository) {
    this.challengeCrudRepository = challengeCrudRepository;
    this.patientHasChallengeCrudRepository = patientHasChallengeCrudRepository;
  }

  public List<Challenge> findAllNotCompleted() {
    // TODO: Rethink how to separate
    return challengeCrudRepository.findAll();
  }

  public List<Challenge> findAllAssignedToCurrentUser() {
    return challengeCrudRepository.findAllAssignedToCurrentUser();
  }

  public Challenge findById(Long id) {
    return challengeCrudRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException(
            String.format("Challenge with id %s not found", id)));
  }

  public void assignToCurrentUser(Long challengeId) {
    patientHasChallengeCrudRepository.assignToCurrentUser(challengeId);
  }
}
