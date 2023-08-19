import { Song } from "./song";

export class Album {
    id: number = 0;
    name: string = '';
    songs: Song[] = [];
    suggestedPrice: number = 0;
}
