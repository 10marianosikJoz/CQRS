package org.cqrs.cinema;

import java.time.LocalDateTime;
import java.util.Set;

class CinemaDataProvider {

    static UpdateCinemaCommand updateCinemaCommand() {
        return new UpdateCinemaCommand(1L, new Address("Lublin", address().street(), "25-222"), movies());
    }

    static CreateCinemaCommand createCinemaCommand() {
        return new CreateCinemaCommand(1L, address(), movies());
    }

    static Address address() {
        return new Address("Warsaw", "Monte Casino", "212-22");
    }

    static Set<Movie> movies() {
        return Set.of(new Movie(1L, "Wither", LocalDateTime.now(), 180L, actors(), reviews()));
    }

    static Set<Actor> actors() {
        return Set.of(new Actor("Patric", "Saxe"));
    }

    static Set<Review> reviews() {
        return Set.of(new Review("Brilliant movie", 5));
    }
}
