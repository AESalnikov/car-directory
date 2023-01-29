package ru.embedika.cardirectory.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Stats {

    @JsonProperty("number_of_records")
    private Long numberOfRecords;

    @JsonProperty("first_data_record")
    private LocalDateTime firstDataRecord;

    @JsonProperty("last_data_record")
    private LocalDateTime lastDataRecord;

}
