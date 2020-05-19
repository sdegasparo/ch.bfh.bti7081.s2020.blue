package ch.bfh.bti7081.s2020.blue.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

@Configuration
public class SpELCOnfiguration {

  @Bean
  public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
    return new SecurityEvaluationContextExtension();
  }
}
