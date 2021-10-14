package com.fintech.backend.controller;


import com.fintech.backend.model.Country;
import com.fintech.backend.service.CountrySearchService;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
@Log4j2
public class CountryController {

  private final CountrySearchService countrySearchService;

  @ApiOperation(value = "return all Country", response = List.class)
  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/get")
  public ResponseEntity<List<Country>> getAllCountries() throws IOException {
    log.info("Get All Country method works");
    return ResponseEntity.ok(this.countrySearchService.getAllCountry());
  }
  @ApiOperation(value = "return Countries which is searched", response = List.class)
  @PostMapping
  public ResponseEntity<List<Country>> searchCountries(@RequestBody String name)
      throws IOException {
    log.info("Search country work");
    log.info("Country: {}", name);
    return ResponseEntity.ok(this.countrySearchService.getSearchedCountry(name));
  }


}
