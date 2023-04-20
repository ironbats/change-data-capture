package com.cdc.architecture.data;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Source {

    private String version;
    private String connector;
    private String name;
    @JsonProperty(value = "ts_ms")
    private String tsMs;
    private boolean snapshot;
    private String db;
    private String sequence;
    private String table;
    @JsonProperty(value = "server_id")
    private Integer serverId;
    private String gtid;
    private String file;
    private Integer pos;
    private Integer row;
    private Integer thread;
}
