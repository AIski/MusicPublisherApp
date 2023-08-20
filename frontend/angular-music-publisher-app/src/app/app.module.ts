import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ArtistComponent } from './component/artist/artist.component';
import { AlbumComponent } from './component/album/album.component';
import { OfferComponent } from './component/offer/offer.component';
import { HomeComponent } from './component/home/home.component';
import { AboutMeComponent } from './component/about-me/about-me.component';
import { RouterModule, Routes } from '@angular/router';
import { AlbumService } from './service/album.service';
import { ArtistService } from './service/artist.service';
import { CountryService } from './service/country.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


const routes: Routes = [
  { path: 'about-me', component: AboutMeComponent },
  { path: 'album', component: AlbumComponent },
  { path: 'artist', component: ArtistComponent },
  { path: 'offer', component: OfferComponent },
  { path: 'home', component: HomeComponent },
  { path: '', component: HomeComponent, pathMatch: 'full' }, 
  { path: '**', redirectTo: 'home' }
];

@NgModule({
  declarations: [
    AppComponent,
    AlbumComponent,
    ArtistComponent,
    HomeComponent,
    OfferComponent,
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
