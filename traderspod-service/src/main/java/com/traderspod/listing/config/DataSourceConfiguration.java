package com.traderspod.listing.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfiguration {

	@Bean
	@ConfigurationProperties("spring.datasource.listing")
	public DataSourceProperties listingDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.listing.hikari")
	public DataSource listingDataSource() {
		return listingDataSourceProperties().initializeDataSourceBuilder().build();
	}
}