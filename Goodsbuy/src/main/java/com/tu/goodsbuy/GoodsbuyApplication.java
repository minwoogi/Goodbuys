package com.tu.goodsbuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan
@SpringBootApplication
public class GoodsbuyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsbuyApplication.class, args);
    }

}
