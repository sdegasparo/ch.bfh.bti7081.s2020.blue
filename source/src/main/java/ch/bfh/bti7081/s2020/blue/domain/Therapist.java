package ch.bfh.bti7081.s2020.blue.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Therapist {

  @Id
  @GenericGenerator(name = "pk_sequence", strategy = PostgreSQLConstants.SEQUENCE_GENERATOR_STRATEGY, parameters = {@Parameter(name = "sequence_name", value = "therapist_id_seq"), @Parameter(name = "increment_size", value = "1")})
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
  private Long id;

  private String title;
  private String surname;
  private String givenName;
  private String street;
  private String place;
  private String information;

  public Therapist() {
  }

  public Therapist(final String title, final String surname, final String givenName, final String street, final String place, final String information) {
    this.title = title;
    this.surname = surname;
    this.givenName = givenName;
    this.street = street;
    this.place = place;
    this.information = information;
  }

  public Long getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setSurname(final String surname) {
    this.surname = surname;
  }

  public String getGivenName() {
    return this.givenName;
  }

  public void setGivenName(final String givenName) {
    this.givenName = givenName;
  }

  public String getStreet() {
    return this.street;
  }

  public void setStreet(final String street) {
    this.street = street;
  }

  public String getPlace() {
    return this.place;
  }

  public void setPlace(final String place) {
    this.place = place;
  }

  public String getInformation() {
    return this.information;
  }

  public void setInformation(final String information) {
    this.information = information;
  }
}
