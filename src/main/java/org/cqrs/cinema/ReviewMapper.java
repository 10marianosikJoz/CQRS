package org.cqrs.cinema;

import org.cqrs.cinema.projection.*;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class ReviewMapper implements Function<Review, ReviewProjection> {

    @Override
    public ReviewProjection apply(Review review) {
        return new ReviewProjection(review.description(),
                                    review.rating());
    }

    Set<ReviewProjection> toReviewProjection(Set<Review> reviews) {
        return reviews.stream().map(this)
                               .collect(Collectors.toSet());
    }
}

class CinemaMapper implements Function<Cinema, CinemaProjection> {

    @Override
    public CinemaProjection apply(Cinema cinema) {
        return new CinemaProjection(cinema.cinemaId(),
                                    new AddressMapper().apply(cinema.address()),
                                    new MovieMapper().toMovieProjection(cinema.repertoire()));
    }
}

class MovieMapper implements Function<Movie, MovieProjection> {

    @Override
    public MovieProjection apply(Movie movie) {
        return new MovieProjection(movie.title(),
                new ActorMapper().toActorProjection(movie.actors()),
                new ReviewMapper().toReviewProjection(movie.reviews()));
    }

    Set<MovieProjection> toMovieProjection(Set<Movie> movies) {
        return movies.stream().map(this)
                .collect(Collectors.toSet());
    }
}

class ActorMapper implements Function<Actor, ActorProjection> {

    @Override
    public ActorProjection apply(Actor actor) {
        return new ActorProjection(actor.name(), actor.surname());
    }

    Set<ActorProjection> toActorProjection(Set<Actor> actors) {
        return actors.stream().map(this)
                              .collect(Collectors.toSet());
    }
}

class AddressMapper implements Function<Address, AddressProjection> {

    @Override
    public AddressProjection apply(Address address) {
        return new AddressProjection(address.city(),
                                     address.street(),
                                     address.postalCode());
    }
}