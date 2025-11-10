package com.cdc.architecture.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class ChangeCDCTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonPropertiesAreDeserializedCorrectly() throws Exception {
        String json = "{" +
                "\"before\":\"old\"," +
                "\"after\":{\"id\":1,\"name\":\"new\",\"quantity\":2}," +
                "\"source\":{\"version\":\"1\",\"connector\":\"mysql\",\"name\":\"simdb\",\"ts_ms\":\"123\",\"snapshot\":false,\"db\":\"inventory\",\"sequence\":\"1\",\"table\":\"lojas\",\"server_id\":1,\"gtid\":\"gtid\",\"file\":\"binlog\",\"pos\":2,\"row\":3,\"thread\":4}," +
                "\"op\":\"c\"," +
                "\"ts_ms\":999," +
                "\"transaction\":\"abc\"" +
                "}";

        ChangeCDC changeCDC = objectMapper.readValue(json, ChangeCDC.class);

        assertEquals("old", changeCDC.getBefore());
        assertNotNull(changeCDC.getAfter());
        assertEquals(1L, changeCDC.getAfter().getId());
        assertEquals("new", changeCDC.getAfter().getName());
        assertEquals(2L, changeCDC.getAfter().getQuantity());
        assertNotNull(changeCDC.getSource());
        assertEquals("lojas", changeCDC.getSource().getTable());
        assertEquals(999L, changeCDC.getTsMs());
        assertEquals("abc", changeCDC.getTransaction());
        assertEquals("c", changeCDC.getOp());
    }
}
