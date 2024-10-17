package br.com.rafaelvieira.springbootbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class printHelloStepConfig {

    @Bean
    public Step step(Tasklet printHelloTasklet, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step", jobRepository)
                .tasklet(printHelloTasklet, transactionManager)
                .build();
    }

//    @Bean
//    @StepScope
//    public Tasklet printHelloTaskletComponent(@Value("#{jobParameters['name']}") String name){
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                System.out.printf("Hello %s%n!", name);
//                return RepeatStatus.FINISHED;
//            }
//        };
//    }
}
