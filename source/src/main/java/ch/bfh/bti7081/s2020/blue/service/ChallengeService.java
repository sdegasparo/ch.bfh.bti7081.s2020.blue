package ch.bfh.bti7081.s2020.blue.service;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import ch.bfh.bti7081.s2020.blue.domain.repository.ChallengeCrudRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {

  private ChallengeCrudRepository challengeCrudRepository;

  public ChallengeService(ChallengeCrudRepository challengeCrudRepository) {
    this.challengeCrudRepository = challengeCrudRepository;
  }

  public List<Challenge> findAllAssignedToCurrentUser() {
    return challengeCrudRepository.findAllAssignedToCurrentUser();
  }

  public Challenge findById(Long id) {
    return challengeCrudRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException(String.format("Challenge with id %s not found", id)));
  }

}
