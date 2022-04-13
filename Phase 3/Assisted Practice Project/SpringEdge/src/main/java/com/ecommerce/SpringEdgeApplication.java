package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringEdgeApplication {

        public static void main(String[] args) {
                SpringApplication.run(SpringEdgeApplication.class, args);
        }

}