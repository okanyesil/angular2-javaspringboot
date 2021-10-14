package com.fintech.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
  @JsonProperty("name")
  private String name;

  @JsonProperty("region")
  private String region;

  @JsonProperty("capital")
  private String capital;

  @JsonProperty("flag")
  private String flag;

  public String toString() {
    return this.name + " " + this.region + " " + this.capital + " " + this.flag;
  }

}
