package com.mx.forty;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement 
public class DatabaseConfig {

	 @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://dadtabse-forty.cv6m4gewkqci.us-east-2.rds.amazonaws.com:3306/forty_db?useSSL=true&allowPublicKeyRetrieval=true&serverTimezone=UTC");
//	        dataSource.setUrl("jdbc:mysql://localhost:3306/forty_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
	        dataSource.setUsername("FtyUsr");
	        dataSource.setPassword("Fg120615@");
	        return dataSource;
	    }

	    // 2. Crear manualmente el PlatformTransactionManager
	 	@Bean(name = "dataSourceTransactionManager")
	    public PlatformTransactionManager dataSourceTransactionManager(DataSource dataSource) {
	        // Para JDBC usamos DataSourceTransactionManager
	        return new DataSourceTransactionManager(dataSource);
	    }
	    
	 	@Primary
	    @Bean(name = "transactionManager")
	    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	        // Para JPA/Hibernate usamos JpaTransactionManager
	        return new JpaTransactionManager(entityManagerFactory);
	    }
}
