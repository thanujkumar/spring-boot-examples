package com.app.restway.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

//    <dependency>
//        <groupId>org.springframework.boot</groupId>
//        <artifactId>spring-boot-starter-data-rest</artifactId>
//    </dependency>

    @RestResource(path = "find")
    Iterable<Car> findByMakeIgnoringCase(@Param("make") String make);
}
