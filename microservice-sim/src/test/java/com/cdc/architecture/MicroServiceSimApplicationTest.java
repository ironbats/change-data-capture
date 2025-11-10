package com.cdc.architecture;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

class MicroServiceSimApplicationTest {

    @Test
    void mainRunsApplication() {
        try (MockedStatic<SpringApplication> springApplication = Mockito.mockStatic(SpringApplication.class)) {
            springApplication.when(() -> SpringApplication.run(Mockito.eq(MicroServiceSimApplication.class), Mockito.any()))
                    .thenReturn(null);
            MicroServiceSimApplication.main(new String[] {"--test"});
            springApplication.verify(() -> SpringApplication.run(Mockito.eq(MicroServiceSimApplication.class), Mockito.any()));
        }
    }
}
