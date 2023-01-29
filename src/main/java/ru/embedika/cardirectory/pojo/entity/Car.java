package ru.embedika.cardirectory.pojo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;

    @Column(name = "year_of_issue")
    private Integer yearOfIssue;

    @Column(name = "date_added")
    private ZonedDateTime dateAdded;

}
