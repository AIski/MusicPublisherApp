# MusicPublisherApp
This is Java Angular Application.
    Usech stack:
    Java 17,
    SpringBoot 3,
    Angular 14,
    H2 Database,
    Lombok,
    Mapstruct
    

    
    Main functionalities:
    1. Create new Artist, given: first name, last name, music type, age, country (
        selected from a list)
    2. Create album, given: album title, list of song names with artists performing each song.
        (One Album can have multiple Songs, each Song can have multiple Artists, selected from
        List). List of artists is being loaded from database (artists can be saved to this 
        DB from create new Artist segment)
    3. Offer of the record company: List of all albums, with: 
       -number of songs on album,
       -suggested price
       - when clicked on each album, new component pops up, showign album details (
       album title, songs, artists, their countries, ages, music types, suggested album price)

       
How to launch the app:
- clone the repo
- open /backend/MusicPublisherApp in IDE(I'm using Intellij), launch theSpringboot MusicPublisherApplication
- open /frontend/angular-music-publisher-app (Angular app), install the deppendencies using npm, serve
- open http://localhost:4200/ for the Frontend page.
