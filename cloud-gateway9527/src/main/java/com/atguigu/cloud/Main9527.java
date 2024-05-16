package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 张益策
 * @version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Main9527 {
    public static void main(String[] args) {
        SpringApplication.run(Main9527.class,args);

    }
}
