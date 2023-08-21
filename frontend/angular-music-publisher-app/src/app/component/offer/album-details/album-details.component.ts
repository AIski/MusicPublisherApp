import { Component, Input, OnInit } from '@angular/core';
import { Album } from 'src/app/common/album';

@Component({
  selector: 'app-album-details',
  templateUrl: './album-details.component.html',
  styleUrls: ['./album-details.component.css']
})
export class AlbumDetailsComponent implements OnInit {
  @Input() album: Album = new Album(); 
  displayComponent: boolean = false;

  ngOnInit(): void {
    if (this.album) {
      this.displayComponent = true;
    }
  }
}
