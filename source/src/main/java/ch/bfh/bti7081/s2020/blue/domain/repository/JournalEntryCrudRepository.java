package ch.bfh.bti7081.s2020.blue.domain.repository;

import ch.bfh.bti7081.s2020.blue.domain.JournalEntry;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryCrudRepository extends CrudRepository<JournalEntry, Long> {

  @Override
  List<JournalEntry> findAll();

  @Modifying
  @Transactional
  @PreAuthorize("isAuthenticated()")
  @Query(value = "insert into journal_entry"
      + "         (title, content, creation_date, patient_id)"
      + "         values (:#{#title}, :#{#content}, :#{#creationDate}, (select id from patient where login_username = :#{principal.username}))",
      nativeQuery = true)
  void create(@Param("title") String title, @Param("content") String content, @Param("creationDate") Date creationDate);

  @Modifying
  @Transactional
  @PreAuthorize("isAuthenticated()")
  @Query(value = "update journal_entry"
      + "         set title = :#{#title},"
      + "             content = :#{#content},"
      + "             creation_date = :#{#creationDate}",
      nativeQuery = true)
  void update(String title, String content, Date creationDate);
}