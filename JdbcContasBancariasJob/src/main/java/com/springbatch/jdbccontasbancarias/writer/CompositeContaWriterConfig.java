package com.springbatch.jdbccontasbancarias.writer;


import com.springbatch.jdbccontasbancarias.dominio.Conta;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompositeContaWriterConfig {

    @Bean
    public CompositeItemWriter<Conta> compositeContaWriter(
           @Qualifier("fileContaWriter") FlatFileItemWriter<Conta> fileContaWriter,
            JdbcBatchItemWriter<Conta> jdbcContaWriter
    ) {
        return new CompositeItemWriterBuilder<Conta>()
            .delegates(fileContaWriter, jdbcContaWriter)
            .build();
    }

    //TODO: Uncomment this code to use the List.of() method
//    @Bean
//    public CompositeItemWriter<Conta> compositeContaWriter(
//            FlatFileItemWriter<Conta> fileContaWriter,
//            JdbcBatchItemWriter<Conta> jdbcContaWriter) {
//        CompositeItemWriter<Conta> compositeItemWriter = new CompositeItemWriter<>();
//        compositeItemWriter.setDelegates(List.of(jdbcContaWriter, fileContaWriter));
//        return compositeItemWriter;
//    }

}
