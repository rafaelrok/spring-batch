package com.springbatch.folhaponto.writer;

import com.springbatch.folhaponto.dominio.FolhaPonto;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class JdbcFolhaPontoWriterConfig {

    @Bean
    public ItemWriter<FolhaPonto> JdbcFolhaPontoWriterConfig(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<FolhaPonto>()
                .dataSource(dataSource)
                .sql("INSERT INTO folha_ponto (matricula, nome, mes, ano, registros_pontos) VALUES (?, ?, ?, ?, ?)")
                .itemPreparedStatementSetter(new ItemPreparedStatementSetter<FolhaPonto>() {
                    @Override
                    public void setValues(FolhaPonto folhaPonto, PreparedStatement ps) throws SQLException {
                        ps.setInt(1, folhaPonto.getMatricula());
                        ps.setString(2, folhaPonto.getNome());
                        ps.setInt(3, folhaPonto.getMes());
                        ps.setInt(4, folhaPonto.getAno());
                        ps.setString(5, folhaPonto.getRegistrosPontoTexto());
                    }
                })
                .build();
    }
}
