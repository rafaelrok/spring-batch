package com.springbatch.jdbccontasbancarias.writer;

import com.springbatch.jdbccontasbancarias.dominio.Conta;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class JdbcContaWriterConfig {

    @Bean
    public JdbcBatchItemWriter<Conta> jdbcContaWriter(@Qualifier("appDataSource") DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Conta>()
            .dataSource(dataSource)
            .sql("INSERT INTO conta (tpo, limite, cliente_id) VALUES (?, ?, ?)")
                .itemPreparedStatementSetter(itemPreparedStatementSetter())
//            .beanMapped()
            .build();
    }

    private ItemPreparedStatementSetter<Conta> itemPreparedStatementSetter() {
        return new ItemPreparedStatementSetter<Conta>() {
            @Override
            public void setValues(Conta conta, PreparedStatement ps) throws SQLException {
                ps.setString(1, conta.getTipo().name());
                ps.setDouble(2, conta.getLimite());
                ps.setString(3, conta.getClienteId());
            }
        };
    }
}
