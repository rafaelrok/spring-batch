package com.udemy.parimparjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintEvenOddStep {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step irintEvenOddStep(ItemReader<Integer> countUntilTenReader,
                                    ItemProcessor<Integer, String> evenOrOddProcessor, ItemWriter<String> printWriter) {
        return stepBuilderFactory.get("printEvenOddStep").<Integer, String>chunk(1).reader(countUntilTenReader)
                .processor(evenOrOddProcessor).writer(printWriter).build();
    }
}
