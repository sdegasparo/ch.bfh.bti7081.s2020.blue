package ch.bfh.bti7081.s2020.blue.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import ch.bfh.bti7081.s2020.blue.domain.Challenge;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ChallengeCrudRepositoryIntegrationTest {

  @Autowired
  ChallengeCrudRepository challengeCrudRepository;

  @Test
  @Transactional
  @WithMockUser(username = "test-username")
  @Sql({
      "classpath:sql/ChallengeCrudRepositoryIntegrationTest_findAllAssignedToCurrentUserReadsPrincipalFromSecurityContext.sql"})
  public void findAllAssignedToCurrentUserReadsPrincipalFromSecurityContext() {
    List<Challenge> challenges = challengeCrudRepository.findAllAssignedToCurrentUser();

    assertThat(challenges).hasSize(1);
    assertThat(challengeCrudRepository.findAllInclusiveAccepted()).hasSize(5);
  }
}
