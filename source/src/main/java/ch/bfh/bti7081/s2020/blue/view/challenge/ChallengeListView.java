package ch.bfh.bti7081.s2020.blue.view.challenge;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import java.util.List;

public interface ChallengeListView {

  void display(List<Challenge> challenges);

  void navigateToDetailView(Long id);

  interface ChallengeListViewListener {

    void onInit();

    void onChallengeClick(Long id);
  }
}
