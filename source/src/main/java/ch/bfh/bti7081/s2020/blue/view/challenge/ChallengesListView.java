package ch.bfh.bti7081.s2020.blue.view.challenge;

import ch.bfh.bti7081.s2020.blue.domain.dto.ChallengeDto;
import java.util.List;

public interface ChallengesListView {

  void display(List<ChallengeDto> challenges);

  interface ChallengesListViewListener {

    void onInit();

    void onChallengeAccept(Long challengeId);
  }
}
