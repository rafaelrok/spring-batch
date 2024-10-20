package com.springbatch.folhaponto.writer;

import com.springbatch.folhaponto.dominio.FolhaPonto;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CompositeFolhaPontoWriterConfig {

    @Bean
    public ItemWriter<FolhaPonto> compositeFolhaPontoWriter(
            ItemWriter<FolhaPonto> JdbcFolhaPontoWriterConfig,
            ItemWriter<FolhaPonto> funcionarioSemPontoWriter) {
        return new ItemWriter<FolhaPonto>() {
            @Override
            public void write(List<? extends FolhaPonto> items) throws Exception {
                JdbcFolhaPontoWriterConfig.write(items);
                funcionarioSemPontoWriter.write(items);
            }
        };
    }
}
