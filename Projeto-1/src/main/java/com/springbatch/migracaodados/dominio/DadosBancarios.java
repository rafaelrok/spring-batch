package com.springbatch.migracaodados.dominio;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DadosBancarios {
	private int id;
	private int pessoaId;
	private int agencia;
	private int conta;
	private int banco;


}
