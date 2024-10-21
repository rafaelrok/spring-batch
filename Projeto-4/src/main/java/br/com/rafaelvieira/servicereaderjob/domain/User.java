package br.com.rafaelvieira.servicereaderjob.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
  private int id;
  private String name;
  private String email;
  private String gender;
  private String status;

  public User() {
  }

    @Override
  public String toString() {
    return "User [email=" + email + ", gender=" + gender + ", id=" + id + ", name=" + name + ", status=" + status + "]";
  }

}
