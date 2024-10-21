package br.com.rafaelvieira.servicereaderjob.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseUser {
  private List<User> data;

  public ResponseUser() {
  }

}
