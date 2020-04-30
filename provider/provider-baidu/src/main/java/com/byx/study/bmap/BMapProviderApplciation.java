package com.byx.study.bmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.imageio.plugins.bmp.BMPImageWriteParam;

@SpringBootApplication
public class BMapProviderApplciation {
    public static void main(String[] args) {
        SpringApplication.run(BMPImageWriteParam.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
