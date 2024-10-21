package com.springbatch.faturacartaocredito.dominio;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Transacao {
	private int id;
	private CartaoCredito cartaoCredito;
	private String descricao;
	private Double valor;
	private Date data;

}
