package com.springbatch.migracaodados.reader;

import java.util.Date;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.validation.BindException;

import com.springbatch.migracaodados.dominio.Pessoa;

@Configuration
public class ArquivoPessoaReaderConfig {
	@Bean
	public FlatFileItemReader<Pessoa> arquivoPessoaReader() {
		return new FlatFileItemReaderBuilder<Pessoa>()
				.name("arquivoPessoaReader")
				.resource(new FileSystemResource("./Projeto-1/files/pessoas.csv"))
				.delimited()
				.names("nome", "email", "dataNascimento", "idade", "id")
				.addComment("--")
				.fieldSetMapper(fieldSetMapper())
				.build();
	}

	//TODO: Repossavel por mapear os objetos lidos do arquivo para o objeto de dominio, quando tem um tipo mais complexo de mapeamento alternativa
	//TODO: do targetType().
	private FieldSetMapper<Pessoa> fieldSetMapper() {
		return new FieldSetMapper<Pessoa>() {

			@Override
			public Pessoa mapFieldSet(FieldSet fieldSet) throws BindException {
				try{
					Pessoa pessoa = new Pessoa();
					pessoa.setNome(fieldSet.readString("nome"));
					pessoa.setEmail(fieldSet.readString("email"));
					pessoa.setDataNascimento(new Date(fieldSet.readDate("dataNascimento", "yyyy-MM-dd HH:mm:ss").getTime()));
					pessoa.setIdade(fieldSet.readInt("idade"));
					pessoa.setId(fieldSet.readInt("id"));
					return pessoa;
				} catch (Exception e) {
					throw new BindException(fieldSet, "pessoa");
				}
			}
		};
	}
}
