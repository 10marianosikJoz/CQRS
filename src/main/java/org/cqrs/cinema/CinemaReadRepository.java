package org.cqrs.cinema;

import java.util.*;

class CinemaReadRepository {

    static final Map<String, Cinema> cinemas = new HashMap<>();
    static final Map<String, Set<Review>> reviewsStore = new HashMap<>();
    static final Map<String, Set<Actor>> actorsStore = new HashMap<>();

    Cinema findCinema(String city) {
        return Optional.ofNullable(cinemas.get(city))
                .orElseThrow(() -> new CinemaDomainException("Cinema not found"));
    }

    Set<Movie> findRepertoire(String city) {
        var cinema = Optional.ofNullable(cinemas.get(city))
                .orElseThrow(() -> new CinemaDomainException("Cinema not found"));

        return cinema.repertoire();
    }

    Set<Review> findReviews(String title) {
        return Optional.ofNullable(reviewsStore.get(title))
                .orElseThrow(() -> new CinemaDomainException("Movie not found"));
    }

    Set<Actor> findActors(String title) {
        return Optional.ofNullable(actorsStore.get(title))
                .orElseThrow(() -> new CinemaDomainException("Actor not found"));
    }
}
