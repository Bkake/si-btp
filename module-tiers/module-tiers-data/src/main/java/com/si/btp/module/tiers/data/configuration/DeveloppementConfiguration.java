package com.si.btp.module.tiers.data.configuration;


import org.h2.jdbcx.JdbcDataSource;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.inject.Inject;
import javax.sql.DataSource;

@Configuration
@ComponentScan({"com.si.btp.module.tiers.data.domain"})
@EnableTransactionManagement
@PropertySource("classpath:db_config.properties")
@Profile("dev")
public class DeveloppementConfiguration {
	
	@Inject
	private Environment environment;
	
	@Bean
	public DataSource dataSource() {
	    JdbcDataSource dataSource = new JdbcDataSource();
	 
	    dataSource.setUrl(environment.getRequiredProperty("db.url"));
	    dataSource.setUser(environment.getRequiredProperty("db.username"));
	    dataSource.setPassword(environment.getRequiredProperty("db.password"));

	    return dataSource; 
	}
	
	@Bean
	public TransactionAwareDataSourceProxy transactionAwareDataSource() {
	    return new TransactionAwareDataSourceProxy(dataSource());
	}
	 
	@Bean
	public DataSourceTransactionManager transactionManager() {
	    return new DataSourceTransactionManager(dataSource());
	}
	 
	@Bean
	public DataSourceConnectionProvider connectionProvider() {
	    return new DataSourceConnectionProvider(transactionAwareDataSource());
	}
	 
	@Bean
	public ExceptionTranslator exceptionTransformer() {
	    return new ExceptionTranslator();
	}
	     
	@Bean
	public DefaultDSLContext dsl() {
	    return new DefaultDSLContext(configuration());
	}
	
	@Bean
	public DefaultConfiguration configuration() {
	    DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
	    jooqConfiguration.set(connectionProvider());
	    jooqConfiguration.set(new DefaultExecuteListenerProvider(exceptionTransformer()));
	 
	    String sqlDialectName = environment.getRequiredProperty("jooq.sql.dialect");
	    SQLDialect dialect = SQLDialect.valueOf(sqlDialectName);
	    jooqConfiguration.set(dialect);
	 
	    return jooqConfiguration;
	}

}
