package br.com.rafaelvieira.contasbancariasjob.processor;

import br.com.rafaelvieira.contasbancariasjob.dominio.Cliente;
import br.com.rafaelvieira.contasbancariasjob.dominio.Conta;
import br.com.rafaelvieira.contasbancariasjob.dominio.TipoConta;
import org.springframework.batch.item.ItemProcessor;

public class ContaTipoProcessor implements ItemProcessor<Cliente, Conta> {

    @Override
    public Conta process(Cliente cliente) {
        Conta conta = new Conta();
        conta.setClienteId(cliente.getEmail());
        conta.setTipo(tipoConta(cliente));
        conta.setLimite(limiteConta(cliente));
        return conta;
    }

    private Double limiteConta(Cliente cliente) {
        return switch (TipoConta.fromFaixaSalarial(cliente.getFaixaSalarial())) {
            case PRATA -> 500.0;
            case OURO -> 1000.0;
            case PLATINA -> 2500.0;
            case DIAMANTE -> 5000.0;
        };
    }

    private TipoConta tipoConta(Cliente cliente) {
        return TipoConta.fromFaixaSalarial(cliente.getFaixaSalarial());
    }
}
