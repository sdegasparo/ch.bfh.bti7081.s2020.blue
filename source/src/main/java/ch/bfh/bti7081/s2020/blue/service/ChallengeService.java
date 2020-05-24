package ch.bfh.bti7081.s2020.blue.service;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import ch.bfh.bti7081.s2020.blue.domain.dto.ChallengeDto;
import ch.bfh.bti7081.s2020.blue.domain.repository.ChallengeCrudRepository;
import ch.bfh.bti7081.s2020.blue.domain.repository.PatientHasChallengeCrudRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChallengeService {

  private static final Comparator<? super ChallengeDto> CHALLENGE_INCOMPLETED_FIRST_COMPARATOR = new Comparator<ChallengeDto>() {
    @Override
    public int compare(ChallengeDto challengeDto1, ChallengeDto challengeDto2) {
      return challengeDto1.getCompleted().compareTo(challengeDto2.getCompleted());
    }
  };

  private final ChallengeCrudRepository challengeCrudRepository;
  private final PatientHasChallengeCrudRepository patientHasChallengeCrudRepository;

  public ChallengeService(ChallengeCrudRepository challengeCrudRepository,
      PatientHasChallengeCrudRepository patientHasChallengeCrudRepository) {
    this.challengeCrudRepository = challengeCrudRepository;
    this.patientHasChallengeCrudRepository = patientHasChallengeCrudRepository;
  }

  @Transactional(readOnly = true)
  public List<ChallengeDto> findAll() {
    return challengeCrudRepository.findAllInclusiveAccepted().stream()
        .map(this::challengeToDto)
        .sorted(CHALLENGE_INCOMPLETED_FIRST_COMPARATOR)
        .collect(Collectors.toList());
  }

  private ChallengeDto challengeToDto(Challenge challenge) {
    return ChallengeDto.builder()
        .id(challenge.getId())
        .name(challenge.getName()).
            content(challenge.getContent())
        .criteria(challenge.getCriteria())
        .accepted(!challenge.getPatients().isEmpty())
        .completed(
            !challenge.getPatients().isEmpty() && challenge.getPatients().get(0).getCompleted())
        .build();
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
