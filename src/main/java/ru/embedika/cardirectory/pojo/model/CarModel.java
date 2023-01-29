package ru.embedika.cardirectory.pojo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CarModel {

    @JsonProperty("car_number")
    private String carNumber;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("color")
    private String color;

    @JsonProperty("year_of_issue")
    private Integer yearOfIssue;

}
