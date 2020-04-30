package com.byx.study.tk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.byx.study.tk.mapper")
public class TkProviderApplciation {
    public static void main(String[] args) {
        SpringApplication.run(TkProviderApplciation.class, args);
    }
}
