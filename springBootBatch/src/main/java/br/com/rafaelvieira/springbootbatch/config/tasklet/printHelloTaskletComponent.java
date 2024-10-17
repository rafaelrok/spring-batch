package br.com.rafaelvieira.springbootbatch.config.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class printHelloTaskletComponent implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        String name = chunkContext.getStepContext().getJobParameters().get("name").toString();
        String jobName = chunkContext.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobName();
        System.out.printf("Hello %s!%n", name);
        System.out.printf("Job Name: %s%n", jobName);
        return RepeatStatus.FINISHED;
    }
}
