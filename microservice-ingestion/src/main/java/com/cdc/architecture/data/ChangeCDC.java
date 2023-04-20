package com.cdc.architecture.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChangeCDC {

    private String before;
    private After after;
    private Source source;
    private String op;
    @JsonProperty(value = "ts_ms")
    private Long tsMs;
    private String transaction;

}
