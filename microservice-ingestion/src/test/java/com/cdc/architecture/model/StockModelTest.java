package com.cdc.architecture.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class StockModelTest {

    @Test
    void gettersAndSettersWorkAsExpected() {
        Lojas lojas = new Lojas();
        lojas.setId(1L);
        lojas.setName("Store");
        lojas.setQuantity(50L);

        StockModel stockModel = new StockModel();
        stockModel.setId(2L);
        stockModel.setLojas(List.of(lojas));
        stockModel.setStockEcommerce(100L);

        assertEquals(2L, stockModel.getId());
        assertIterableEquals(List.of(lojas), stockModel.getLojas());
        assertEquals(100L, stockModel.getStockEcommerce());
    }
}
