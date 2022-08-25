package com.freefriday.testcontainers;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

public class ContainerAbstractClass {

    @Container
    private static final MySQLContainer container = (MySQLContainer) new MySQLContainer("mysql:8.0.26").withReuse(true);

    @DynamicPropertySource
    public static void overrideProperties(DynamicPropertyRegistry propertyRegistry) {
        propertyRegistry.add("spring.datasource.url",container::getJdbcUrl);
        propertyRegistry.add("spring.datasource.username",container::getUsername);
        propertyRegistry.add("spring.datasource.password",container::getPassword);
    }

    @BeforeAll
    public static void setup() {
        container.start();
    }

}
