package com.baar.countryapp.controller;

import com.baar.countryapp.dto.CountryDto;
import com.baar.countryapp.service.CountryServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

  private CountryServiceImpl countryServiceImpl;

  public CountryController(CountryServiceImpl countryServiceImpl) {
    this.countryServiceImpl = countryServiceImpl;
  }

  @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<CountryDto>> getAllCountries() {
    return new ResponseEntity<>(countryServiceImpl.getAllCountries(), HttpStatus.OK);
  }
}
