package com.cdc.architecture;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

class IngestionApplicationTest {

    @Test
    void mainRunsApplication() {
        try (MockedStatic<SpringApplication> springApplication = Mockito.mockStatic(SpringApplication.class)) {
            springApplication.when(() -> SpringApplication.run(Mockito.eq(IngestionApplication.class), Mockito.any()))
                    .thenReturn(null);
            IngestionApplication.main(new String[] {"--test"});
            springApplication.verify(() -> SpringApplication.run(Mockito.eq(IngestionApplication.class), Mockito.any()));
        }
    }
}
