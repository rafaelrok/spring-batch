package com.springbatch.enviopromocoesemail.dominio;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private Double preco;

}
