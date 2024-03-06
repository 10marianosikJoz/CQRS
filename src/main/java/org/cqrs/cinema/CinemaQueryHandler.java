package org.cqrs.cinema;

import org.cqrs.cinema.projection.ActorProjection;
import org.cqrs.cinema.projection.CinemaProjection;
import org.cqrs.cinema.projection.MovieProjection;
import org.cqrs.cinema.projection.ReviewProjection;

import java.util.Set;
import java.util.stream.Collectors;

class CinemaQueryHandler {

    private final CinemaReadRepository cinemaReadRepository;

    CinemaQueryHandler(final CinemaReadRepository cinemaReadRepository) {
        this.cinemaReadRepository = cinemaReadRepository;
    }

    CinemaProjection cinemaByCity(CinemaByCityQuery query) {
        return new CinemaMapper().apply(cinemaReadRepository.findCinema(query.city()));
    }

    Set<MovieProjection> repertoireByCinema(CinemaByCityQuery query) {
        return cinemaReadRepository.findRepertoire(query.city()).stream()
                                                                .map(it -> new MovieMapper().apply(it))
                                                                .collect(Collectors.toSet());
    }

    Set<ReviewProjection> reviewsByMovie(ReviewByFilmTitleQuery query) {
        return cinemaReadRepository.findReviews(query.title()).stream()
                                                              .map(it -> new ReviewMapper().apply(it))
                                                              .collect(Collectors.toSet());
    }

    Set<ActorProjection> actorByMovieTitle(ActorByMovieTitleQuery query) {
        return cinemaReadRepository.findActors(query.title()).stream()
                                                             .map(it -> new ActorMapper().apply(it))
                                                             .collect(Collectors.toSet());
    }
}
