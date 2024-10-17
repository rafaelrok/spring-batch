package com.udemy.parimparjob.step.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class printWriterService {
    @Bean
    public ItemWriter<String> printWriter() {
        return items -> items.forEach(System.out::println);
    }
}
