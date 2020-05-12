package ch.bfh.bti7081.s2020.blue.domain.repository;

import ch.bfh.bti7081.s2020.blue.domain.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientCrudRepository extends CrudRepository<Patient, String> {

}
