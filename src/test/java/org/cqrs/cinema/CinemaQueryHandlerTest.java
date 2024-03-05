package org.cqrs.cinema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CinemaQueryHandlerTest {

    private final CinemaProjector cinemaProjector = new CinemaProjector();

    private CinemaQueryHandler cinemaQueryHandler;
    private CinemaCommandHandler cinemaCommandHandler;

    @BeforeEach
    void setUp() {
        var cinemaWriteRepository = new CinemaWriteRepository();
        cinemaCommandHandler = new CinemaCommandHandler(cinemaWriteRepository);
        CinemaReadRepository cinemaReadRepository = new CinemaReadRepository();
        cinemaQueryHandler = new CinemaQueryHandler(cinemaReadRepository);
    }

    @Test
    void shouldFindCinemaByCity() {
        //given
        var cinema = cinemaCommandHandler.handleCreateCinemaCommand(CinemaDataProvider.createCinemaCommand());
        var query = new CinemaByCityQuery("Warsaw");

        //when
        cinemaProjector.aggregate(cinema);
        var result = cinemaQueryHandler.cinemaByCity(query);

        //then
        assertThat(result.cinemaId()).isEqualTo(1L);
        assertThat(result.address().street()).isEqualTo("Monte Casino");
    }

    @Test
    void shouldReturnCurrentRepertoireInCinema() {
        //given
        var cinema = cinemaCommandHandler.handleCreateCinemaCommand(CinemaDataProvider.createCinemaCommand());
        var query = new CinemaByCityQuery("Warsaw");

        //when
        cinemaProjector.aggregate(cinema);
        var result = cinemaQueryHandler.repertoireByCinema(query);
        var titles = result.stream()
                           .map(MovieProjection::title)
                           .toList();

        //then
        assertThat(titles.get(0)).isEqualTo("Wither");
    }

    @Test
    void shouldReturnAllMovieReviews() {
        //given
        var cinema = cinemaCommandHandler.handleCreateCinemaCommand(CinemaDataProvider.createCinemaCommand());
        var query = new ReviewByFilmTitleQuery("Wither");

        //when
        cinemaProjector.aggregate(cinema);
        var result = cinemaQueryHandler.reviewsByMovie(query);
        var reviews = result.stream()
                            .map(review -> review.description() + " " + review.rating())
                            .toList();

        //then
        assertThat(reviews.get(0)).isEqualTo("Brilliant movie 5");
    }

    @Test
    void shouldReturnAllMovieActors() {
        //given
        var cinema = cinemaCommandHandler.handleCreateCinemaCommand(CinemaDataProvider.createCinemaCommand());
        var query = new ActorByMovieTitleQuery("Wither");

        //when
        cinemaProjector.aggregate(cinema);
        var result = cinemaQueryHandler.actorByMovieTitle(query);
        var actors = result.stream()
                           .map(actor -> actor.name() + " " + actor.surname())
                           .toList();

        //then
        assertThat(actors.get(0)).isEqualTo("Patric Saxe");
    }

    @Test
    void shouldUpdateCinemaInformation() {
        //given
        var cinema = cinemaCommandHandler.handleUpdateCinemaCommand(CinemaDataProvider.updateCinemaCommand());
        var query = new CinemaByCityQuery("Lublin");

        //when
        cinemaProjector.aggregate(cinema);
        var result = cinemaQueryHandler.cinemaByCity(query);

        //then
        assertThat(result.cinemaId()).isEqualTo(1L);
        assertThat(result.address().city()).isEqualTo("Lublin");
    }
}