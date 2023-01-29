package ru.embedika.cardirectory.pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.embedika.cardirectory.pojo.model.CarModel;

import java.util.List;

@Data
public class GetCarListResponse {

    @JsonProperty("car_list")
    private List<CarModel> carList;

}
