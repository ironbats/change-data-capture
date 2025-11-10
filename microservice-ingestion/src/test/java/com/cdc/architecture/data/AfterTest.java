package com.cdc.architecture.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AfterTest {

    @Test
    void gettersAndSettersWorkAsExpected() {
        After after = new After();
        after.setId(1L);
        after.setName("Updated store");
        after.setQuantity(99L);

        assertEquals(1L, after.getId());
        assertEquals("Updated store", after.getName());
        assertEquals(99L, after.getQuantity());
    }
}
