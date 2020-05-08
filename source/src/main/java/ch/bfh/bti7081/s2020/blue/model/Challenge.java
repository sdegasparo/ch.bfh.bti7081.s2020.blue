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
public class Challenge {

  private String name;
  private String content;
  private String criteria;
  private List<Reward> rewards;
}
