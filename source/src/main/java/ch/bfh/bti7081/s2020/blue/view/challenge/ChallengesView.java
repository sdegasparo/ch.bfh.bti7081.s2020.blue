package ch.bfh.bti7081.s2020.blue.view.challenge;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import java.util.List;

public interface ChallengesView {

  void display(List<Challenge> challenges);


  interface ChallengesViewListener {

    void onInit();

    void onChallengeAccept(Long challengeId);
  }
}
