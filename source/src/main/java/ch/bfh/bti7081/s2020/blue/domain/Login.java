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

  private Boolean isEnabled;
  private Boolean isBlocked;

  @OneToOne(mappedBy = "login", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private Patient patient;

  public Login() {
  }

  public Login(final String username, final String email, final String password, final Boolean isEnabled, final Boolean isBlocked, final Patient patient) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.isEnabled = isEnabled;
    this.isBlocked = isBlocked;
    this.patient = patient;
  }

  public static Login.LoginBuilder builder() {
    return new Login.LoginBuilder();
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

  public static class LoginBuilder {

    private String username;
    private String email;
    private String password;
    private Boolean isEnabled;
    private Boolean isBlocked;
    private Patient patient;

    LoginBuilder() {
    }

    public Login.LoginBuilder username(final String username) {
      this.username = username;
      return this;
    }

    public Login.LoginBuilder email(final String email) {
      this.email = email;
      return this;
    }

    public Login.LoginBuilder password(final String password) {
      this.password = password;
      return this;
    }

    public Login.LoginBuilder isEnabled(final Boolean isEnabled) {
      this.isEnabled = isEnabled;
      return this;
    }

    public Login.LoginBuilder isBlocked(final Boolean isBlocked) {
      this.isBlocked = isBlocked;
      return this;
    }

    public Login.LoginBuilder patient(final Patient patient) {
      this.patient = patient;
      return this;
    }

    public Login build() {
      return new Login(this.username, this.email, this.password, this.isEnabled, this.isBlocked, this.patient);
    }

    @Override
    public java.lang.String toString() {
      return "Login.LoginBuilder(username=" + this.username + ", email=" + this.email + ", password=" + this.password + ", isEnabled=" + this.isEnabled + ", isBlocked=" + this.isBlocked + ", patient=" + this.patient + ")";
    }
  }
}
