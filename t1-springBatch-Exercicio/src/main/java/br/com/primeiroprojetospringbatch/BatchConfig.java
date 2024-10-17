package br.com.primeiroprojetospringbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  //TODO: Versão com erro, pois não estava configurada o banco de dados e não estava recuperando o nome
//  @Bean
//  public Step imprimeOlaStep() {
//    return stepBuilderFactory
//        .get("imprimeOlaStep")
//        .tasklet((StepContribution contribution, ChunkContext chunkContext) -> {
//          System.out.println("Olá, mundo!");
//          return RepeatStatus.FINISHED;
//        }).build();
//  }
//
//  @Bean
//  public Job imprimeOlaJob() {
//    return jobBuilderFactory
//        .get("imprimeOlaJob")
//        .start(imprimeOlaStep())
//        .build();
//  }

    //TODO: Correção exercise: Modificar para recuperar o nome na tasklet registrada como Bean e em contexto de step
    public Step imprimeOlaStep() {
        return stepBuilderFactory.get("imprimeOlaStep").tasklet(imprimeOlaTasklet(null)).build();
    }

    @Bean
    @StepScope
    public Tasklet imprimeOlaTasklet(@Value("#{jobParameters['nome']}") String nome) {
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println(String.format("Olá, %s!", nome));
                return RepeatStatus.FINISHED;
            }
        };
    }
}
