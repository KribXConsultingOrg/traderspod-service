package com.traderspod.listing;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
//@PropertySource("classpath:/test.properties")
@ComponentScan(basePackages="com.traderspod.listing")
public class TestConfig {

}
