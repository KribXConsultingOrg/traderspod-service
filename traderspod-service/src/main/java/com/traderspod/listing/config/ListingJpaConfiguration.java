package com.traderspod.listing.config;

import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (
  basePackages = {"com.traderspod.listing"},
  entityManagerFactoryRef = "listingEntityManagerFactory",
  transactionManagerRef = "listingTransactionManager"
)
public class ListingJpaConfiguration {

	@Bean
    public LocalContainerEntityManagerFactoryBean listingEntityManagerFactory (
      @Qualifier("listingDataSource") DataSource dataSource,
      EntityManagerFactoryBuilder builder) {
        return builder
          .dataSource(dataSource)
          .packages("com.traderspod.listing")
          .build();
    }

    @Bean
    public PlatformTransactionManager listingTransactionManager(
      @Qualifier("listingEntityManagerFactory") LocalContainerEntityManagerFactoryBean listingEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(listingEntityManagerFactory.getObject()));
    }
}
