package com.jumia.test.config;

/**
 *
 * @author martin
 */
import java.io.IOException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {
    
    @Value("${SQLITEDB_PATH}")
    private String db_path;

    @Bean
    public DataSource dataSource() throws IOException {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
        dataSourceBuilder.url("jdbc:sqlite:"+db_path);
        return dataSourceBuilder.build();
    }
}
