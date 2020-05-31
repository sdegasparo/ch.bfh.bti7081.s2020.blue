package ch.bfh.bti7081.s2020.blue.view.therapist;

import ch.bfh.bti7081.s2020.blue.domain.Therapist;
import java.util.List;

public interface TherapistListView {

  void display(List<Therapist> therapists);

  interface TherapistViewListener {

    void onInit();
  }
}
