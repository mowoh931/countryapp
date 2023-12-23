package com.baar.countryapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class CountryappApplication {

  public static void main(String[] args) {
    SpringApplication.run(CountryappApplication.class, args);
    log.info("Country app running here................");
  }
}
