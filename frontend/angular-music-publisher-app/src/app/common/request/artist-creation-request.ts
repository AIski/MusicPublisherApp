import { Country } from "../country";

export class ArtistCreationRequest {
    firstName: string = '';
    lastName: string = '';
    musicType: string = '';
    age: number = 0;
    country: Country = new Country();
}
