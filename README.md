# Testcontainers
This repo consists in a solution 
to use Testcontainers (TC) to test database operations. It's written as a Java Springboot project, helped by Maven.




**Important:** Always check if docker and docker compose utilities are installed in the machine being used.



The links of interest are:

- TC: https://www.testcontainers.org/quickstart/junit_5_quickstart/
- live-coding session from Jet Brains "Testcontainers – From Zero to Hero": https://youtu.be/v3eQCIWLYOw
- more advanced integration tests with TC: https://www.baeldung.com/spring-boot-testcontainers-integration-test

<br />

## Install and Build
Don't forget to perform
``` docker-compose up``` in the same directory as the one containing the docker-compose.yml file.

Then, the artifact itself:

First install
``` ./mvnw clean install```

Then, run
``` ./mvnw spring-boot:run```

<br />

## Lessons Learned
1) Using an Abstract class (as [ContainerAbstractClass](/src/test/java/com/freefriday/testcontainers/ContainerAbstractClass.java)), allows reusing the prepared container for multiple tests without concurrence problems;
2) Container ports are random. To by-pass this, @DynamicPropertySource annotation overrides the connection info from application.properties;
3) Method `.withReuse(true)` allows reusing the db container, with all original data;  

<br />

## Next steps
- More advanced database operations;
- Db logs extraction, from the container;
- Networking possibilities, "daisy-chaining" : https://www.testcontainers.org/features/networking/ 