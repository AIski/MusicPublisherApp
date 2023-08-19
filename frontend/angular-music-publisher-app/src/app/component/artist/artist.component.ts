import { Component, OnInit } from '@angular/core';
import { Observable, firstValueFrom } from 'rxjs';
import { Country } from 'src/app/common/country';
import { CountryService } from 'src/app/service/country.service';

@Component({
  selector: 'app-artist',
  templateUrl: './artist.component.html',
  styleUrls: ['./artist.component.css']
})
export class ArtistComponent implements OnInit {
  countries: Country[] = [];
  displayComponent: Boolean = false;

  constructor(
    private countryService: CountryService
  ) { }

  async ngOnInit(): Promise<void> {
    await this.getCountries();
    this.displayComponent = true;
    
  }


  async getCountries(): Promise<void> {
    try {
      this.countries = (await this.countryService.getCountries()).body!;
    } catch (error) {
      console.error('Error fetching countries:', error);
    }
  }

}
