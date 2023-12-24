package com.baar.countryapp.controller;

import com.baar.countryapp.dto.CountryDto;
import com.baar.countryapp.exception.CountryNotFoundException;
import com.baar.countryapp.service.CountryServiceImpl;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/countries")
@RequestMapping
public class CountryController {

  private CountryServiceImpl countryServiceImpl;

  public CountryController(CountryServiceImpl countryServiceImpl) {
    this.countryServiceImpl = countryServiceImpl;
  }
  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> greetings() {
    return new ResponseEntity<>("HELLO WORLD!", HttpStatus.OK);
  }
  @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<CountryDto>> getAllCountries() {
    return new ResponseEntity<>(countryServiceImpl.getAllCountries(), HttpStatus.OK);
  }

  @GetMapping(value = "/get/country/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CountryDto> getAllCountry(@PathVariable("id") Integer id) {
    return new ResponseEntity<>(
        countryServiceImpl.getAllCountries().stream().filter(country -> country.getId()==id)
            .findFirst()
            .orElseThrow(() -> new CountryNotFoundException("Country not found!")),
        HttpStatus.OK);
  }
}
