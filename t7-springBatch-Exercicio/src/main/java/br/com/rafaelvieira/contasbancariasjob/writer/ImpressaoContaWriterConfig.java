package br.com.rafaelvieira.contasbancariasjob.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.rafaelvieira.contasbancariasjob.dominio.Conta;

@Configuration
public class ImpressaoContaWriterConfig {
	@Bean
	ItemWriter<Conta> impressaoContaWriter() {
		return contas -> contas.forEach(System.out::println);
	}
}
