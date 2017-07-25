package org.univth.mangobanana.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by TaeHwan
 * 2017. 7. 24. PM 3:33
 */
@Configuration
public class DbConfig {
    @Bean
    public DataSource dataSource(){
        HikariDataSource config = new HikariDataSource();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://localhost:32768/local_database");
        config.setUsername("mangobanana");
        config.setPassword("a0000001");
        return config;
    }
}
