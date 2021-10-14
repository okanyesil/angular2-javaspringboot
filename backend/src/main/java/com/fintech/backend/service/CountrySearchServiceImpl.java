package com.fintech.backend.service;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fintech.backend.model.Country;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CountrySearchServiceImpl implements CountrySearchService {


  @Override
  public List<Country> getAllCountry() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    Country[] allCountries = objectMapper.readValue(new ClassPathResource("restcountries.json").getFile(), Country[].class);

    return List.of(allCountries);
  }

  @Override
  public List<Country> getSearchedCountry(String capital) throws IOException {
    List<Country> countryList = new ArrayList<>();
    log.debug("Country: {}", capital);
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    Country[] allCountries = objectMapper.readValue(new ClassPathResource("restcountries.json").getFile(), Country[].class);
    Arrays.stream(allCountries).filter(value -> {
      if (value.getCapital() != null) {
        return value.getCapital().toLowerCase(Locale.ROOT).contains(capital.toLowerCase(Locale.ROOT));
      }
      return false;
    }).forEach(value -> countryList.add(value));


    return countryList;
  }
}
