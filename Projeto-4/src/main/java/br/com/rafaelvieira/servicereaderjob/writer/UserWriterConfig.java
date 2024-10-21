package br.com.rafaelvieira.servicereaderjob.writer;


import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.rafaelvieira.servicereaderjob.domain.User;

@Configuration
public class UserWriterConfig {
  @Bean
  public ItemWriter<User> userWriter() {
    return items -> items.forEach(System.out::println);
  }
}
