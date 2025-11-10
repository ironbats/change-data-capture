package com.cdc.architecture;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CdcApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void mainRunsApplication() {
        try (MockedStatic<SpringApplication> springApplication = Mockito.mockStatic(SpringApplication.class)) {
            springApplication.when(() -> SpringApplication.run(Mockito.eq(CdcApplication.class), Mockito.any())).thenReturn(null);
            CdcApplication.main(new String[] { "--test" });
            springApplication.verify(() -> SpringApplication.run(Mockito.eq(CdcApplication.class), Mockito.any()));
        }
    }

}
