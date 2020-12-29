package ua.com.foxminded.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import ua.com.foxminded.dao.ClassroomDao;

import javax.sql.*;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("ua.com.foxminded")
@EnableWebMvc
public class SpringConfig {
    @Value("${driver}")
    String driver;
    
    @Value("${url}")
    String url;
    
    @Value("${user}")
    String user;
    
    @Value("${password}")
    String password;
    
    @Value("${schema}")
    String schema;

    private final ApplicationContext applicationContext;
    

    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }    
    
    @Bean
    public DataSource getDataSource() {        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setSchema(schema);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return  dataSource;
    }
    
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
    
}
