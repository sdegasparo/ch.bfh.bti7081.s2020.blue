package ch.bfh.bti7081.s2020.blue.domain.dto;

public class ValidationError {

  String message;

  public ValidationError() {
  }

  public ValidationError(final String message) {
    this.message = message;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }
}
