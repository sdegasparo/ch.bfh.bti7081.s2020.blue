package ch.bfh.bti7081.s2020.blue.view.challenge;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import java.util.List;

public interface CurrentChallengesListView {

  void display(List<Challenge> challenges);

  void navigateToChallenges();

  void navigateToDetailView(Long id);

  interface CurrentChallengesListViewListener {

    void onInit();

    void onChallengeAcceptClick();

    void onChallengeClick(Long id);
  }
}
