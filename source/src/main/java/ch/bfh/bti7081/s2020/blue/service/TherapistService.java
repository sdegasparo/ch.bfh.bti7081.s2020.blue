package ch.bfh.bti7081.s2020.blue.service;

import ch.bfh.bti7081.s2020.blue.domain.Therapist;
import ch.bfh.bti7081.s2020.blue.domain.repository.TherapistCrudRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TherapistService {

  private final TherapistCrudRepository therapistCrudRepository;

  public TherapistService(TherapistCrudRepository therapistCrudRepository) {
    this.therapistCrudRepository = therapistCrudRepository;
  }

  public List<Therapist> findAll() {
    return therapistCrudRepository.findAll();
  }
}
