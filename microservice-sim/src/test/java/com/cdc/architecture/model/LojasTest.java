package com.cdc.architecture.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LojasTest {

    @Test
    void gettersAndSettersWorkAsExpected() {
        Lojas lojas = new Lojas();
        lojas.setId(10L);
        lojas.setName("Main store");
        lojas.setQuantity(30L);

        assertEquals(10L, lojas.getId());
        assertEquals("Main store", lojas.getName());
        assertEquals(30L, lojas.getQuantity());
    }
}
