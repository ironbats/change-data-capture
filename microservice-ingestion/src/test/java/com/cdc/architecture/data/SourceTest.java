package com.cdc.architecture.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class SourceTest {

    @Test
    void gettersAndSettersWorkAsExpected() {
        Source source = new Source();
        source.setVersion("1.0");
        source.setConnector("mysql");
        source.setName("simdb");
        source.setTsMs("123456");
        source.setSnapshot(false);
        source.setDb("inventory");
        source.setSequence("1");
        source.setTable("lojas");
        source.setServerId(12);
        source.setGtid("gtid");
        source.setFile("binlog");
        source.setPos(3);
        source.setRow(4);
        source.setThread(5);

        assertEquals("1.0", source.getVersion());
        assertEquals("mysql", source.getConnector());
        assertEquals("simdb", source.getName());
        assertEquals("123456", source.getTsMs());
        assertFalse(source.isSnapshot());
        assertEquals("inventory", source.getDb());
        assertEquals("1", source.getSequence());
        assertEquals("lojas", source.getTable());
        assertEquals(Integer.valueOf(12), source.getServerId());
        assertEquals("gtid", source.getGtid());
        assertEquals("binlog", source.getFile());
        assertEquals(Integer.valueOf(3), source.getPos());
        assertEquals(Integer.valueOf(4), source.getRow());
        assertEquals(Integer.valueOf(5), source.getThread());
    }
}
