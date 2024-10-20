package com.springbatch.jdbccontasbancarias.processor;


import com.springbatch.jdbccontasbancarias.dominio.Cliente;
import com.springbatch.jdbccontasbancarias.dominio.Conta;
import org.springframework.batch.item.ItemProcessor;


public class ContaInvalidaItemProcessor implements ItemProcessor<Cliente, Conta> {

    @Override
    public Conta process(Cliente cliente) throws Exception {
        Conta conta = new Conta();
        conta.setClienteId(cliente.getEmail());
        return conta;
    }
}
