package org.cqrs.cinema;

import java.util.Set;

class DataSynchronizer {

    private DataSynchronizer() {}

    static void addFilmReviews(String title, Set<Review> reviews) {
        CinemaReadRepository.reviewsStore.put(title, reviews);
    }

    static void addMovieActors(String name, Set<Actor> actors) {
        CinemaReadRepository.actorsStore.put(name, actors);
    }

    static void addCinemaAddress(Cinema cinema, Address address) {
        CinemaReadRepository.cinemas.put(address.city(), cinema);
    }
}
