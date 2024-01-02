package org.springboot.ex1;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class Ex1ApplicationTests {

    @Test
    void contextLoads() {


        System.out.println("Hello World!");
        log.info("Hello World!");
    }
}
