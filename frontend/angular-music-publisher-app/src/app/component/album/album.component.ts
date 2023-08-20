import { Component, OnInit } from '@angular/core';
import { AbstractControl, Form, FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Artist } from 'src/app/common/artist';
import { AlbumService } from 'src/app/service/album.service';
import { ArtistService } from 'src/app/service/artist.service';

@Component({
  selector: 'app-album',
  templateUrl: './album.component.html',
  styleUrls: ['./album.component.css']
})
export class AlbumComponent implements OnInit {
  artists: Artist[] = [];
  displayComponent: Boolean = false;
  albumForm!: FormGroup;
  successMessage!: string;
  errorMessage!: string;


  constructor(
    private artistService: ArtistService,
    private albumService: AlbumService,
    private formBuilder: FormBuilder
  ) { }

  async ngOnInit(): Promise<void> {
    await this.getArtists();
    this.createAlbumForm();
    this.displayComponent = true;
  }

  async getArtists(): Promise<void> {
    try {
      this.artists = (await this.artistService.getArtists()).body!;
    } catch (error) {
      console.error('Error fetching artists:', error);
    }
  }

  async onSubmit(): Promise<void> {
    if (this.albumForm.valid) {
      const albumCreationRequest = this.albumForm.value;

      try {
        const response = await this.albumService.createAlbum(albumCreationRequest);
        if (response.status === 200) {
          this.successMessage = 'Album saved to database successfully.';
          this.albumForm.reset();
        }
      } catch (error) {
        this.errorMessage = 'Error creating Album: ' + JSON.stringify(error);
        console.error('Error creating artist: ' + JSON.stringify(error));
      }
    }
  }

  createAlbumForm(): void {
    this.albumForm = this.formBuilder.group({
      name: ['', Validators.required],
      suggestedPrice: [0, Validators.required],
      songs: this.formBuilder.array([
        this.createSongFormGroup(),
        this.createSongFormGroup(),
      ])
    });
  }

  createSongFormGroup(): FormGroup {
    return this.formBuilder.group({
      name: ['', Validators.required],
      artistIds: [[], Validators.required],
    });
  }

  getSongsControls(): AbstractControl[] {
    return (this.albumForm.get('songs') as FormArray).controls;
  }

  addSong(): void {
    const songsArray = this.albumForm.get('songs') as FormArray;
    songsArray.push(this.createSongFormGroup());
  }

  removeSong(index: number): void {
    const songsArray = this.albumForm.get('songs') as FormArray;
    songsArray.removeAt(index);
  }

}
