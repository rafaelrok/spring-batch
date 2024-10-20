package com.springbatch.migracaodados.dominio;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;

@Setter
@Getter
public class Pessoa {
	private int id;
	private String nome;
	private String email;
	private Date dataNascimento;
	private int idade;

    public boolean isValida() {
		return !Strings.isBlank(nome) && !Strings.isBlank(email) && dataNascimento != null;
	}


}
