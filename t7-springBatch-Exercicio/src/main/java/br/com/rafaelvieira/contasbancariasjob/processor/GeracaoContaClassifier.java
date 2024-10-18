package br.com.rafaelvieira.contasbancariasjob.processor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;

import br.com.rafaelvieira.contasbancariasjob.dominio.Cliente;
import br.com.rafaelvieira.contasbancariasjob.dominio.Conta;
import br.com.rafaelvieira.contasbancariasjob.dominio.TipoConta;

public class GeracaoContaClassifier implements Classifier<Cliente, ItemProcessor<?, ? extends Conta>> {

	private static final Map<TipoConta, ItemProcessor<Cliente, Conta>> processadores = new HashMap<>() {
        {
            put(TipoConta.PRATA, new ContaTipoProcessor());
            put(TipoConta.OURO, new ContaTipoProcessor());
            put(TipoConta.PLATINA, new ContaTipoProcessor());
            put(TipoConta.DIAMANTE, new ContaTipoProcessor());
        }
    };

	@Override
	public ItemProcessor<Cliente, Conta> classify(Cliente cliente) {
		TipoConta tipoConta = TipoConta.fromFaixaSalarial(cliente.getFaixaSalarial());
		return processadores.get(tipoConta);
	}

}
