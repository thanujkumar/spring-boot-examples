package com.app.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "CAR")
@Data
@NoArgsConstructor
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String make;

    @Column
    private String model;

    @Column
    private int myear;

    public Car(String make, String model, int myear) {
        this.make = make;
        this.model = model;
        this.myear = myear;
    }
}
