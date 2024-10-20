package com.springbatch.jdbccontasbancarias.writer;


import com.springbatch.jdbccontasbancarias.dominio.Conta;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ClienteInvalidoWriterConfig {

    @Bean
    public FlatFileItemWriter<Conta> clienteInvalidoWriter() {
        return new FlatFileItemWriterBuilder<Conta>()
                .name("clienteInvalidoWriter")
                .resource(new FileSystemResource("./JdbcContasBancariasJob/files/clientesInvalidos.txt"))
                .delimited()
                .names("clienteId" )
                .build();
    }
}
