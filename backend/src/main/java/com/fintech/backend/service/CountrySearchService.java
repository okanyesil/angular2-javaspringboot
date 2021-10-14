package com.fintech.backend.service;

import com.fintech.backend.model.Country;
import java.io.IOException;
import java.util.List;

public interface CountrySearchService {
  List<Country> getAllCountry() throws IOException;
  List<Country> getSearchedCountry(String country) throws IOException;



}
