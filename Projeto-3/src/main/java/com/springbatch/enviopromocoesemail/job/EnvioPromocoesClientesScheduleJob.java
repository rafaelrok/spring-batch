package com.springbatch.enviopromocoesemail.job;

import lombok.AllArgsConstructor;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.quartz.QuartzJobBean;

@AllArgsConstructor
public class EnvioPromocoesClientesScheduleJob extends QuartzJobBean {

	private final Job job;
	private final JobExplorer jobExplorer;
	private final JobLauncher jobLauncher;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		JobParameters jobParameters = new JobParametersBuilder(this.jobExplorer).getNextJobParameters(this.job).toJobParameters();
		try {
			this.jobLauncher.run(this.job, jobParameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
