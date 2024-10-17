package br.com.rafaelvieira.springbootbatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloJobBatchConfig {

    @Bean
    public Job job(JobRepository jobRepository, Step step){
        return new JobBuilder("job", jobRepository)
                .start(step)
                //TODO RunIncrementer Executar o Job e implementa um Id a cada job, dessa forma permite executar o job novamente sem precisar limpar
                //TODO Não aplicável caso o Job precisa ser reinicializado
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
