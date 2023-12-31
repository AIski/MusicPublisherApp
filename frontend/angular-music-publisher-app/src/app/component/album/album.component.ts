import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormArray, AbstractControl, FormGroup, Validators } from '@angular/forms';
import { Artist } from 'src/app/common/artist';
import { AlbumCreationRequest } from 'src/app/common/request/album-creation-request';
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
  submitted: Boolean = false;

  constructor(
    private artistService: ArtistService,
    private albumService: AlbumService,
    private formBuilder: FormBuilder,
    private cdRef: ChangeDetectorRef
  ) {}

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
    this.submitted = true;
    if (this.albumForm.valid) {
      const albumCreationRequest: AlbumCreationRequest = {
        name: this.albumForm.value.name,
        songs: this.albumForm.value.songs.map((song: any) => ({
          name: song.name,
          artistsIds: song.artistsIds.map((id: number) => +id)
        })),
        suggestedPrice: this.albumForm.value.suggestedPrice
      };
      try {
        const response = await this.albumService.createAlbum(albumCreationRequest);
        if (response.status === 200) {
          this.successMessage = 'Album saved to database successfully.';
          this.createAlbumForm(); //reset albumForm with 1 songs inside
          this.submitted = false;
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
      suggestedPrice: [, Validators.required],
      songs: this.formBuilder.array([this.createSongFormGroup()], Validators.required)
    });
  }

  private createSongFormGroup(): FormGroup {
    return this.formBuilder.group({
      name: ['', Validators.required],
      artistsIds: [[], Validators.required]
    });
  }

  addSong(): void {
    const songsArray = this.albumForm.get('songs') as FormArray;
    songsArray.push(this.createSongFormGroup());
    this.cdRef.detectChanges();
  }

  removeSong(index: number): void {
    const songsArray = this.albumForm.get('songs') as FormArray;
    songsArray.removeAt(index);
  }

  getSongsControls(): AbstractControl[] {
    return (this.albumForm.get('songs') as FormArray).controls;
  }

  isFormGroup(control: AbstractControl): control is FormGroup {
    return control instanceof FormGroup;
  }
}
