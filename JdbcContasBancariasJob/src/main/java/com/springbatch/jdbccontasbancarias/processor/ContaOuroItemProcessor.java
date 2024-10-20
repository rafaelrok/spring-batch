package com.springbatch.jdbccontasbancarias.processor;

import org.springframework.batch.item.ItemProcessor;

import com.springbatch.jdbccontasbancarias.dominio.Cliente;
import com.springbatch.jdbccontasbancarias.dominio.Conta;
import com.springbatch.jdbccontasbancarias.dominio.TipoConta;

public class ContaOuroItemProcessor implements ItemProcessor<Cliente, Conta> {

	@Override
	public Conta process(Cliente cliente) throws Exception {
		Conta conta = new Conta();
		conta.setClienteId(cliente.getEmail());
		conta.setTipo(TipoConta.OURO);
		conta.setLimite(1000.0);
		return conta;
	}

}
