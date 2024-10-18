package br.com.rafaelvieira.contasbancariasjob.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContasBancariasJobConfig {
	private final JobRepository jobRepository;

	public ContasBancariasJobConfig(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Bean
	Job contasBancariasJob(Step criacaoContasStep) {
		return new JobBuilder("contasBancariasJob", jobRepository)
				.start(criacaoContasStep)
				// Para não precisar apagar os metadados.
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
