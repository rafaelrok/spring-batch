package com.springbatch.enviopromocoesemail;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppEnvioPromocoesClientesJob {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		SpringApplication.run(AppEnvioPromocoesClientesJob.class, args);
	}

}
