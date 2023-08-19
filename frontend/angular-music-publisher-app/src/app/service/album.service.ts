import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { Album } from '../common/album';
import { AlbumCreationRequest } from '../common/request/album-creation-request';

@Injectable({
  providedIn: 'root'
})
export class AlbumService {

  private baseUrl = 'http://localhost:8080/api/v1/album';

  constructor(private http: HttpClient) {}

  getAlbums(): Promise<HttpResponse<Album[]>> {
    return firstValueFrom(this.http.get<Album[]>(this.baseUrl, { observe: 'response' }));
  }

  async createAlbum(albumCreationRequest: AlbumCreationRequest): Promise<HttpResponse<Object>> {
    const createAlbumUrl = `${this.baseUrl}/create`;
    return firstValueFrom(
      this.http.post<AlbumCreationRequest>(createAlbumUrl, albumCreationRequest, { observe: 'response' })
    );
  }
}
