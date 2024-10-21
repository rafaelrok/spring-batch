package com.springbatch.enviopromocoesemail.dominio;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InteresseProdutoCliente {
	private Cliente cliente;
	private Produto produto;

}
