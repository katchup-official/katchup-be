package com.katchup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class KatchupApplication {

    public static void main(String[] args) {
        SpringApplication.run(KatchupApplication.class, args);
    }
}
