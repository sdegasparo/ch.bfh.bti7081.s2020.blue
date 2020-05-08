package ch.bfh.bti7081.s2020.blue.model;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reward {

  private String name;
  private String description;
  private int points;
  private Optional<Achievement> achievement;
}
