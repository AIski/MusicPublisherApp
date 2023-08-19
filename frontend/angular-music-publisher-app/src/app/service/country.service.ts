import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, firstValueFrom } from 'rxjs';
import { Country } from '../common/country';

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  private baseUrl = 'http://localhost:8080/api/v1/country';

  constructor(private http: HttpClient) {}

  getCountries(): Promise<HttpResponse<Country[]>> {
    return firstValueFrom(this.http.get<Country[]>(this.baseUrl, { observe: 'response' }));
  }
}
