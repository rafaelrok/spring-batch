package com.springbatch.jdbccontasbancarias.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.jdbccontasbancarias.dominio.Cliente;
import com.springbatch.jdbccontasbancarias.dominio.Conta;

@Configuration
public class GeracaoContaProcessorConfig {
	@Bean
	public ItemProcessor<Cliente, Conta> geracaoContaProcessor() {
		return new ClassifierCompositeItemProcessorBuilder<Cliente, Conta>()
				.classifier(new GeracaoContaClassifier())
				.build();
	}
}
