package ru.goncharov.todolist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
@ComponentScan("ru.goncharov.todolist")
public class TdApplication {

    public static void main(String[] args) {
        SpringApplication.run(TdApplication.class, args);
    }

    @Value("${DriverClassName}")
    private String driverClassName;

    @Value("${Url}")
    private String url;

    @Value("${PGUsername}")
    private String username;

    @Value("${PGPassword}")
    private String password;

    //DB connection
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    //JDBC
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}


