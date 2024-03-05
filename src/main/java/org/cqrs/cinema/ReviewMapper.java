package org.cqrs.cinema;

import java.util.function.Function;

class ReviewMapper implements Function<Review, ReviewProjection> {

    @Override
    public ReviewProjection apply(Review review) {
        return new ReviewProjection(review.description(), review.rating());
    }
}

class CinemaMapper implements Function<Cinema, CinemaProjection> {

    @Override
    public CinemaProjection apply(Cinema cinema) {
        return new CinemaProjection(cinema.cinemaId(), cinema.address(), cinema.repertoire());
    }
}

class MovieMapper implements Function<Movie, MovieProjection> {

    @Override
    public MovieProjection apply(Movie movie) {
        return new MovieProjection(movie.title(), movie.actors(), movie.reviews());
    }
}

class ActorMapper implements Function<Actor, ActorProjection> {

    @Override
    public ActorProjection apply(Actor actor) {
        return new ActorProjection(actor.name(), actor.surname());
    }
}