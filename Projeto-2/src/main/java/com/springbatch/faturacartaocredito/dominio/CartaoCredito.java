package com.springbatch.faturacartaocredito.dominio;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartaoCredito {
	private int numeroCartaoCredito;
	private Cliente cliente;

}
