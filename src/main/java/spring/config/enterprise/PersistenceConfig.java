package spring.config.enterprise;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = "spring.persistence.daos", repositoryImplementationPostfix = "Impl")
@EnableTransactionManagement
public class PersistenceConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("dataSource.driverClassName"));
        dataSource.setUrl(environment.getProperty("dataSource.url"));
        dataSource.setUsername(environment.getProperty("dataSource.username"));
        dataSource.setPassword(environment.getProperty("dataSource.password"));
        LogManager.getLogger(this.getClass()).info("Datasource: " + dataSource.getUrl());
        return dataSource;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.connection.charSet", "UTF-8");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        //create-drop, create, update, validate
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));

        // Recomendación de Madeja
        // hibernate.dialect = org.hibernate.dialect.HSQLDialect
        // hibernate.c3p0.min_size = 5
        // hibernate.c3p0.max_size = 20
        // hibernate.c3p0.timeout = 300
        // hibernate.c3p0.max_statements = 50
        // hibernate.c3p0.idle_test_period = 3000
        //
        // hibernate.show_sql = true
        // hibernate.format_sql = true

        entityManagerFactoryBean.setJpaProperties(properties);
        entityManagerFactoryBean.setPackagesToScan("spring.persistence.entities");
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }

}
