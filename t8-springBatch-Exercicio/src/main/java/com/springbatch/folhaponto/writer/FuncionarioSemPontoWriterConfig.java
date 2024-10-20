package com.springbatch.folhaponto.writer;

import com.springbatch.folhaponto.dominio.FolhaPonto;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Configuration
public class FuncionarioSemPontoWriterConfig {

    @Bean
    public ItemWriter<FolhaPonto> funcionarioSemPontoWriter() {
        return new ItemWriter<FolhaPonto>() {
            @Override
            public void write(List<? extends FolhaPonto> items) throws Exception {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("./t8-springBatch-Exercicio/file/funcionarios_sem_ponto.txt"))) {
                    for (FolhaPonto folhaPonto : items) {
                        if (folhaPonto.getRegistrosPontos().isEmpty()) {
                            writer.write(String.valueOf(folhaPonto.getMatricula()));
                            writer.newLine();
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException("Error writing to file", e);
                }
            }
        };
    }
}
