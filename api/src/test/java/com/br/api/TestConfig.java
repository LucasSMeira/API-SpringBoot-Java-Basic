package com.br.api;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;


@TestConfiguration
@EnableAutoConfiguration(exclude = SqlInitializationAutoConfiguration.class)
@ComponentScan(basePackages = {"com.br.api"})
public class TestConfig {
    // Configurações específicas do teste
}