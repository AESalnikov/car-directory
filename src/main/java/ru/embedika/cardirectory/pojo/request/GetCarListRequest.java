package ru.embedika.cardirectory.pojo.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetCarListRequest {

    @JsonProperty("car_number")
    private String carNumber;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("color")
    private String color;

    @JsonProperty("year_of_issue")
    private Integer yearOfIssue;

}
