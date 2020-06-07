package ch.bfh.bti7081.s2020.blue.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import ch.bfh.bti7081.s2020.blue.domain.association.patientchallenge.PatientHasChallenge;
import ch.bfh.bti7081.s2020.blue.domain.dto.ChallengeDto;
import ch.bfh.bti7081.s2020.blue.domain.repository.ChallengeCrudRepository;
import ch.bfh.bti7081.s2020.blue.domain.repository.PatientHasChallengeCrudRepository;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChallengeServiceUnitTest {

  @Mock
  ChallengeCrudRepository challengeCrudRepositoryMock;

  @Mock
  PatientHasChallengeCrudRepository patientHasChallengeCrudRepositoryMock;

  ChallengeService fixture;

  @Before
  public void beforeTestSetup() {
    fixture = new ChallengeService(challengeCrudRepositoryMock, patientHasChallengeCrudRepositoryMock);
  }

  @Test
  public void findAllReturnsChallengeDtosSortedByNotAcceptedFirst() {
    Challenge challenge1 = Challenge.builder()
        .patients(Collections.singletonList(PatientHasChallenge.builder()
            .completed(Boolean.TRUE)
            .build()))
        .build();

    Challenge challenge2 = Challenge.builder()
        .build();

    doReturn(List.of(challenge1, challenge2))
        .when(challengeCrudRepositoryMock)
        .findAllInclusiveAccepted();

    List<ChallengeDto> result = fixture.findAll();

    assertThat(result)
        .extracting("accepted")
        .containsExactly(Boolean.FALSE, Boolean.TRUE);

    assertThat(result)
        .extracting("completed")
        .containsExactly(Boolean.FALSE, Boolean.TRUE);
  }
}
