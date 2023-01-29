package ru.embedika.cardirectory.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorMessage {

    @JsonProperty("error_code")
    private Integer code;

    @JsonProperty("error_message")
    private String message;

}
