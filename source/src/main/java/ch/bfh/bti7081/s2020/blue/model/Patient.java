package ch.bfh.bti7081.s2020.blue.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

  private String username;
  private String surname;
  private String givenName;
  private String password;
  private String email;
  private List<JournalEntry> journalEntries;
  private List<Achievement> achievements;
  private List<Challenge> challenges;
  private List<ChallengeCompletion> challengeCompletions;
}
