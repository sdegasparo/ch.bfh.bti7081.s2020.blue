package ch.bfh.bti7081.s2020.blue.domain;

import java.util.Collection;
import java.util.Collections;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class Login implements UserDetails {

  public static final transient PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

  @Id
  private String username;

  private String email;

  @Column(columnDefinition = "BPCHAR(60)")
  private String password;

  private Boolean isEnabled = Boolean.TRUE;
  private Boolean isBlocked = Boolean.FALSE;

  @OneToOne(mappedBy = "login", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private Patient patient;

  public Login() {
  }

  public Login(final String username, final String email, final String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new SimpleGrantedAuthority("patient"));
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !isBlocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return isEnabled;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public Boolean getIsEnabled() {
    return this.isEnabled;
  }

  public void setIsEnabled(final Boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  public Boolean getIsBlocked() {
    return this.isBlocked;
  }

  public void setIsBlocked(final Boolean isBlocked) {
    this.isBlocked = isBlocked;
  }

  public Patient getPatient() {
    return this.patient;
  }

  public void setPatient(final Patient patient) {
    this.patient = patient;
  }
}
