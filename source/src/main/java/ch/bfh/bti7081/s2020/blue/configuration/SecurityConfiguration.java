package ch.bfh.bti7081.s2020.blue.configuration;

import ch.bfh.bti7081.s2020.blue.domain.Login;
import ch.bfh.bti7081.s2020.blue.security.FrameworkIgnoringRequestCache;
import ch.bfh.bti7081.s2020.blue.util.SecurityUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final UserDetailsService databaseUserDetailsService;

  public SecurityConfiguration(UserDetailsService databaseUserDetailsService) {
    this.databaseUserDetailsService = databaseUserDetailsService;
  }

  /**
   * Require login to access internal pages and configure login form.
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Not using Spring CSRF here to be able to use plain HTML for the login page
    http.csrf().disable()

        // Register our CustomRequestCache that saves unauthorized access attempts, so
        // the user is redirected after login.
        .requestCache().requestCache(new FrameworkIgnoringRequestCache())

        // Restrict access to our application.
        .and().authorizeRequests()
        .antMatchers("/", "/login", "/register").permitAll()

        // Allow all flow internal requests.
        .requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll()

        // Allow all requests by logged in users.
        .anyRequest().authenticated() //

        // Configure the login page.
        .and().formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/home", true)

        // Configure logout
        .and().logout().logoutUrl("/logout");
  }

  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers(
        // Vaadin Flow static resources //
        "/VAADIN/**",
        // the standard favicon URI
        "/favicon.ico",
        // the robots exclusion standard
        "/robots.txt",
        // web application manifest //
        "/manifest.webmanifest",
        "/sw.js",
        "/offline-page.html",
        // (development mode) static resources //
        "/frontend/**",
        // (development mode) webjars //
        "/webjars/**",
        // (production mode) static resources //
        "/frontend-es5/**", "/frontend-es6/**");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(databaseUserDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(Login.PASSWORD_ENCODER);

    authenticationManagerBuilder.authenticationProvider(daoAuthenticationProvider);
  }
}
