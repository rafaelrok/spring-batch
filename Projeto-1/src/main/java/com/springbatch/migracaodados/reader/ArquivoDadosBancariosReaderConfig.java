package com.springbatch.migracaodados.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.springbatch.migracaodados.dominio.DadosBancarios;

@Configuration
public class ArquivoDadosBancariosReaderConfig {

	@Bean
	public FlatFileItemReader<DadosBancarios> dadosBancariosReader() {
		return new FlatFileItemReaderBuilder<DadosBancarios>()
				.name("dadosBancariosReader")
				.resource(new FileSystemResource("./Projeto-1/files/dados_bancarios.csv"))
				.delimited()
				.names("pessoaId", "agencia", "conta", "banco", "id")
				.addComment("--") //TODO: Verificar se é possível adicionar comentários no arquivo de leitura, ajuda ignorar comentarios do tipo --
				.targetType(DadosBancarios.class) //TODO: Repossavel por mapear os objetos lidos do arquivo para o objeto de dominio
				.build();
	}
}
