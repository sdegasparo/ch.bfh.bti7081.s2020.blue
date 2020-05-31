package ch.bfh.bti7081.s2020.blue.domain.repository;

import ch.bfh.bti7081.s2020.blue.domain.Therapist;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TherapistCrudRepository extends CrudRepository<Therapist, Long> {

  @Override
  List<Therapist> findAll();
}
