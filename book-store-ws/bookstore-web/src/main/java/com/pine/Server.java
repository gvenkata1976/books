package com.pine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.pine.filters.pre.GatewayFilter;

@EnableZuulProxy
@SpringBootApplication
public class Server {

  public static void main(String[] args) {
    SpringApplication.run(Server.class, args);
  }
 
  @Bean
  public GatewayFilter filter() {
    return new GatewayFilter();
  }
}
