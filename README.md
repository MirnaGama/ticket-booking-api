## About the project
API developed in Java and SpringBoot framework for a online movie ticket booking system based on the <a href="https://medium.com/@ashishkp220/design-bookmyshow-ticketmaster-online-movie-ticket-booking-system-bd0b140912d6">BookMyShow article</a>

### Database Design
1. Each City can have multiple Cinemas.
2. Each Cinema will have multiple halls.
3. Each Movie will have many Sessions and each Sessions will have multiple Bookings.
4. A user can have multiple bookings.


### Required user workflow
1. The user searches for a movie.
2. The user selects a movie.
3. The user is shown the available sessions of the movie.
4. The user selects a show.
5. The user selects the number of seats to be reserved.
6. If the required number of seats are available, the user is shown a map of the theater to select seats. If not, the user is taken to ‘step 8’ below.
7. Once the user selects the seat, the system will try to reserve those selected seats.
8. If seats can’t be reserved, we have the following options:
- Session is full; the user is shown the error message.
- The seats the user wants to reserve are no longer available, but there are other seats available, so the user is taken back to the theater map to choose different seats.