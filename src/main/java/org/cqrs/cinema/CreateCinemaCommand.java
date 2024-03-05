package org.cqrs.cinema;

import java.util.Set;

record CreateCinemaCommand(Long cinemaId,
                           Address address,
                           Set<Movie> repertoire) {}
