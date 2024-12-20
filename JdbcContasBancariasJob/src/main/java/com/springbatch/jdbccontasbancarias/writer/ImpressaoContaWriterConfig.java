package com.springbatch.jdbccontasbancarias.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.jdbccontasbancarias.dominio.Conta;

@Configuration
public class ImpressaoContaWriterConfig {
	@Bean
	public ItemWriter<Conta> impressaoContaWriter() {
		return contas -> contas.forEach(System.out::println);
	}
}
