import { SongCreationRequest } from "./song-creation-request";

export class AlbumCreationRequest {
    name: string = '';
    songs: SongCreationRequest[] = [];
    suggestedPrice: number = 0;
}
