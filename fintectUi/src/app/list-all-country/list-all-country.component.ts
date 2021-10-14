import { Component, OnInit } from '@angular/core';
import {CountryService} from "../services/country.service";
import {Observable} from "rxjs";
import {CountryModel} from "../models/countryModel";

@Component({
  selector: 'app-list-all-country',
  templateUrl: './list-all-country.component.html',
  styleUrls: ['./list-all-country.component.scss']
})
export class ListAllCountryComponent implements OnInit {
  allCountry$: Observable<CountryModel[]> | Observable<CountryModel> ;

  constructor(
    private httpService: CountryService
  ) { }

  ngOnInit(): void {
    this.allCountry$ = this.httpService.getAllCountry();
  }
  searchCountry(name): any {
    if (name.target.value.length === 0){
      this.allCountry$ = this.httpService.getAllCountry();
    } else {
      this.allCountry$ =  this.httpService.searchCountry(name.target.value);
    }
  }

}
