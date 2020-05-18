package ch.bfh.bti7081.s2020.blue.service;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {

  private final List<Challenge> challenges = List.of(
      Challenge.builder()
          .id(1L)
          .name("Monster Slayer")
          .content("Kill 10 monsters")
          .build(),
      Challenge.builder()
          .id(2L)
          .name("Pet Collector")
          .content("Collect 10 pets")
          .build(),
      Challenge.builder()
          .id(3L)
          .name("Mount Collector")
          .content("Collect 10 mounts")
          .build()
  );

  public List<Challenge> findAll() {
    return challenges;
  }

  public Challenge findById(Long id) {
    return challenges.stream()
        .filter(challenge -> challenge.getId().equals(id))
        .findFirst()
        .get();
  }

}
