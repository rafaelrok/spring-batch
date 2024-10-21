package br.com.rafaelvieira.servicereaderjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppServiceReaderJob {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppServiceReaderJob.class, args);
		context.close();
	}

}
