package br.com.rafaelvieira.springbootbatch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class PropsConfig {

    //TODO: Implementar a configuração para ler o arquivo de propriedades esternalizado, onde pode configurar em outro local para um ambiente de produção
    @Bean
    public PropertySourcesPlaceholderConfigurer configurer(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new FileSystemResource("D:\\workspace\\Spring\\springBootBatch\\src\\main\\resources\\application.properties"));
        return configurer;
    }
}
