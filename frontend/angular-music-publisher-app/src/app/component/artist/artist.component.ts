import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable, firstValueFrom } from 'rxjs';
import { Country } from 'src/app/common/country';
import { ArtistCreationRequest } from 'src/app/common/request/artist-creation-request';
import { ArtistService } from 'src/app/service/artist.service';
import { CountryService } from 'src/app/service/country.service';

@Component({
  selector: 'app-artist',
  templateUrl: './artist.component.html',
  styleUrls: ['./artist.component.css']
})
export class ArtistComponent implements OnInit {
  countries: Country[] = [];
  displayComponent: Boolean = false;
  artistForm!: FormGroup;
  successMessage!: string;
  errorMessage!: string;


  constructor(
    private countryService: CountryService,
    private artistService: ArtistService,
    private formBuilder: FormBuilder
  ) { }

  async ngOnInit(): Promise<void> {
    await this.getCountries();
    this.createArtistForm();
    this.displayComponent = true;
  }

  createArtistForm(): void {
    this.artistForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      musicType: ['', Validators.required],
      age: [0, Validators.required],
      country: [new Country(), Validators.required]
    });
  }


  async getCountries(): Promise<void> {
    try {
      this.countries = (await this.countryService.getCountries()).body!;
    } catch (error) {
      console.error('Error fetching countries:', error);
    }
  }

  async onSubmit(): Promise<void> {
    if (this.artistForm.valid) {
      const artistCreationRequest= this.artistForm.value;
  

      try {
        const response = await this.artistService.createArtist(artistCreationRequest);
        if (response.status === 200) {
          this.successMessage = 'Artist saved to database successfully.';
          this.artistForm.reset();
        }
      } catch (error) {
        this.errorMessage = 'Error creating artist: '+ JSON.stringify(error);
        console.error('Error creating artist: '+ JSON.stringify(error));
      }
    }
  }

}
