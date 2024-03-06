package org.cqrs.cinema;

class CinemaProjector {

    void aggregate(Cinema cinema) {
        DataSynchronizer.addCinemaAddress(cinema, cinema.address());
        cinema.repertoire().forEach(it -> DataSynchronizer.addMovieReviews(it.title(), it.reviews()));
        cinema.repertoire().forEach(it -> DataSynchronizer.addMovieActors(it.title(), it.actors()));
    }
}
