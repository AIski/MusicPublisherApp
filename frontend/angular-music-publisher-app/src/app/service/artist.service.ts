import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Artist } from '../common/artist';
import { firstValueFrom } from 'rxjs';
import { ArtistCreationRequest } from '../common/request/artist-creation-request';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {
  private baseUrl = 'http://localhost:8080/api/v1/artist';

  constructor(private http: HttpClient) {}

  getArtists(): Promise<HttpResponse<Artist[]>> {
    return firstValueFrom(this.http.get<Artist[]>(this.baseUrl, { observe: 'response' }));
  }

  async createArtist(artistCreationRequest: ArtistCreationRequest): Promise<HttpResponse<Object>> {
    const createArtistUrl = `${this.baseUrl}/create`;
    return firstValueFrom(
      this.http.post<ArtistCreationRequest>(createArtistUrl, artistCreationRequest, { observe: 'response' })
    );
  }
}

