import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CountryModel} from '../models/countryModel';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  constructor(
    private http: HttpClient
  ) { }
  getAllCountry(): Observable<CountryModel[]> {
    return this.http.get<CountryModel[]>('http://localhost:8080/country/get');
  }
  searchCountry(countryName: string): Observable<CountryModel[]> | Observable<CountryModel> {
    return this.http.post<CountryModel>('http://localhost:8080/country/', countryName);
  }
}
