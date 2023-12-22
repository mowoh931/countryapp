package com.baar.countryapp.service;

import com.baar.countryapp.dto.CountryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
  @Override
  public List<CountryDto> getAllCountries() {
    CountryDto usa = CountryDto.builder().id(1).name("USA").capital("Washington DC").build();
    CountryDto china = CountryDto.builder().id(2).name("China").capital("Beiging DC").build();
    CountryDto egypt = CountryDto.builder().id(3).name("Egypt").capital("Cairo").build();
    return List.of(usa, china,egypt);
  }
}
