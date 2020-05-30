package ch.bfh.bti7081.s2020.blue.view.challenge;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;

public interface ChallengeDetailView {

  void display(Challenge challenge);

  void afterChallengeCompleted();

  interface ChallengeDetailViewListener {

    void onInit(Long challengeId);

    void onChallengeComplete(Long challengeId);
  }
}
