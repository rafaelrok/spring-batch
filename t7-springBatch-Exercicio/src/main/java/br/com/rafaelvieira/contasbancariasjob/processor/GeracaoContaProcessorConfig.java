package br.com.rafaelvieira.contasbancariasjob.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.rafaelvieira.contasbancariasjob.dominio.Cliente;
import br.com.rafaelvieira.contasbancariasjob.dominio.Conta;

@Configuration
public class GeracaoContaProcessorConfig {
	@Bean
	ItemProcessor<Cliente, Conta> geracaoContaProcessor() {
		return new ClassifierCompositeItemProcessorBuilder<Cliente, Conta>()
				.classifier(new GeracaoContaClassifier())
				.build();
	}
}
