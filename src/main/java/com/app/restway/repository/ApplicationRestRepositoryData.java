package com.app.restway.repository;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//https://www.baeldung.com/spring-boot-h2-database
@SpringBootApplication
public class ApplicationRestRepositoryData {
    static {
        System.setProperty("debug","true");
    }

    //http://localhost:9000/test/h2-console/login.jsp?jsessionid=9e474dbfcdcb6f2912e325fbf9f3b8cb

//    @Bean
//    public DataSource dataSource() {
//        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
//        DataSource dataSource = databaseBuilder.setType(EmbeddedDatabaseType.H2).build();
//        return dataSource;
//    }

    @Bean
    InitializingBean seedDatabase(CarRepository repository) {
        return () -> {
            repository.save(new Car("Honda", "Civic", 1977));
            repository.save(new Car("Honda", "Accord", 2003));
            repository.save(new Car("Maruti", "Ritz", 2010));
        };
    }

    @Bean
    CommandLineRunner exampleQuery(CarRepository repository) {
        return args -> repository.findByMakeIgnoringCase("HONDA").forEach(System.err::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRestRepositoryData.class, args);
    }
}
