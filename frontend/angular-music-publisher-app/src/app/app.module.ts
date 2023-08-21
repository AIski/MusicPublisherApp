import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ArtistComponent } from './component/artist/artist.component';
import { AlbumComponent } from './component/album/album.component';
import { OfferComponent } from './component/offer/offer.component';
import { RouterModule, Routes } from '@angular/router';
import { AlbumService } from './service/album.service';
import { ArtistService } from './service/artist.service';
import { CountryService } from './service/country.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AlbumDetailsComponent } from './component/offer/album-details/album-details.component';


const routes: Routes = [
  { path: 'album', component: AlbumComponent },
  { path: 'artist', component: ArtistComponent },
  { path: 'offer', component: OfferComponent },
  { path: '', component: OfferComponent, pathMatch: 'full' },
  { path: '**', redirectTo: 'offer' }
];

@NgModule({
  declarations: [
    AppComponent,
    AlbumComponent,
    ArtistComponent,
    OfferComponent,
    AlbumDetailsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    AlbumService,
    ArtistService,
    CountryService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
