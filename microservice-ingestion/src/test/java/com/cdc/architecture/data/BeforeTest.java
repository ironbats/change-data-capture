package com.cdc.architecture.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BeforeTest {

    @Test
    void instancesWithoutFieldsAreEqual() {
        Before first = new Before();
        Before second = new Before();

        assertEquals(first, second);
    }
}
