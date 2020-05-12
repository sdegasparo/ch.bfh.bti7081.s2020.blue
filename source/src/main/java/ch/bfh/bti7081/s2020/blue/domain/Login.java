package ch.bfh.bti7081.s2020.blue.domain;

import java.util.Collection;
import java.util.Collections;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Login implements UserDetails {

  @Id
  private String username;

  private String email;

  @Column(columnDefinition = "BPCHAR(60)")
  private String password;

  private Boolean isEnabled;
  private Boolean isBlocked;

  @OneToOne(mappedBy = "login", cascade = {CascadeType.DETACH, CascadeType.MERGE,
      CascadeType.PERSIST, CascadeType.REFRESH})
  private Patient patient;

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
}