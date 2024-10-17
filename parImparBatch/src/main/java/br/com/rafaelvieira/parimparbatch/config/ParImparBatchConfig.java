package br.com.rafaelvieira.parimparbatch.config;

import jakarta.annotation.Nonnull;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
public class ParImparBatchConfig {

    @Bean
    public Job printParImparJob(JobRepository jobRepository, Step printParImparChunkStep) {
        return new JobBuilder("printParImparJob", jobRepository)
                .start(printParImparChunkStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step printParImparChunkStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("printParImparChunkStep", jobRepository)
                //TODO chunkSize pode ser alterado para melhor performance, porém é preciso garatir memoria se não, pode prejudicar performance e tendo a queda mas pode ocorrer falha no processamento e perder os dados.
                //TODO deve ser efetuado um teste impirico para analisar e levantar todos requisitos de maquina para configurar o chunkSize.
                .<Integer, String>chunk(1, transactionManager)
                .reader(parImparReader())
                .processor(parOrImparProcessor())
                .writer(printWriter())
                .build();
    }

    public IteratorItemReader<Integer> parImparReader() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new IteratorItemReader<>(numbers.iterator());
    }

    public ItemProcessor<? super Integer, ? extends String> parOrImparProcessor() {
        return new ItemProcessor<Integer, String>() {
            @Override
            public String process(@Nonnull Integer item) throws Exception {
                return item % 2 == 0 ? String.format("Number %s is Par", item) : String.format("Number %s is Impar", item);
            }
        };
    }

    public ItemWriter<? super String> printWriter() {
        return items -> items.forEach(System.out::println);
    }
}
