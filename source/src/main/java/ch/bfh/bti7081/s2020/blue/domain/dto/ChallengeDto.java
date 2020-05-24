package ch.bfh.bti7081.s2020.blue.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeDto {

  Long id;
  String name;
  String content;
  String criteria;
  Boolean accepted;
  Boolean completed;
}
