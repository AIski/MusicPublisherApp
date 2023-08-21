import { Component, OnInit } from '@angular/core';
import { Album } from 'src/app/common/album';
import { AlbumService } from 'src/app/service/album.service';
import { AlbumDetailsComponent } from './album-details/album-details.component';



@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.css']
})
export class OfferComponent implements OnInit {
  albums: Album[] = [];
  displayComponent: Boolean = false;
  selectedAlbum: Album = new Album();


  constructor(
  private albumService: AlbumService,
  ) { }

  async ngOnInit(): Promise<void> {
    await this.getAlbums();
    this.displayComponent = true;
  }

  async getAlbums(): Promise<void> {
    try {
      this.albums = (await this.albumService.getAlbums()).body!;
    } catch (error) {
      console.error('Error fetching albums:', error);
    }
  }

  // openModal(album: Album) {
  //   const modalRef = this.modalService.open(AlbumDetailsComponent, { size: 'md' });
  //   modalRef.componentInstance.album = album;
  // }

  openModal(album: Album) {
    console.log(album.name)
    this.selectedAlbum = album;
  }

  closeModal() {
    this.selectedAlbum = new Album();
  }
}
