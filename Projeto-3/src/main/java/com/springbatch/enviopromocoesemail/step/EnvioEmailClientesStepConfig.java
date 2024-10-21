package com.springbatch.enviopromocoesemail.step;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

import com.springbatch.enviopromocoesemail.dominio.InteresseProdutoCliente;

@AllArgsConstructor
@Configuration
public class EnvioEmailClientesStepConfig {

	private final StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step enviaEmailClientesStep(
			ItemReader<InteresseProdutoCliente> lerInteresseProdutoClienteReader,
			ItemProcessor<InteresseProdutoCliente, SimpleMailMessage> processarEmailProdutoClienteProcessor,
			ItemWriter<SimpleMailMessage> enviarEmailProdutoClienteWriter) {
		return stepBuilderFactory
				.get("enviaEmailClientesStep")
				.<InteresseProdutoCliente, SimpleMailMessage>chunk(1)
				.reader(lerInteresseProdutoClienteReader)
				.processor(processarEmailProdutoClienteProcessor)
				.writer(enviarEmailProdutoClienteWriter)
				.build();
	}
}
