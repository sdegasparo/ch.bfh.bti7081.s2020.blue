package ch.bfh.bti7081.s2020.blue.domain.repository;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryCrudRepository extends CrudRepository<JournalEntry, Long> {

  @PreAuthorize("isAuthenticated()")
  @Query(value = "select * from journal_entry where journal_entry.patient_id = (select id from patient where login_username = :#{principal.username})",
      nativeQuery = true)
  List<JournalEntry> findAllByCurrentUser();

  @PreAuthorize("isAuthenticated()")
  JournalEntry save(JournalEntry entry);

  @PreAuthorize("isAuthenticated()")
  @Modifying
  @Transactional
  @Query(value = "update journal_entry"
      + "         set title = :#{#title},"
      + "             content = :#{#content},"
      + "             creation_date = :#{#creationDate}"
      + "         where journal_entry.id = :#{#id}",
      nativeQuery = true)
  void update(Long id, String title, String content, Date creationDate);

}
