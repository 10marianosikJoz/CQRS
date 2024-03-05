package org.cqrs.cinema;

import java.util.Set;

record UpdateCinemaCommand(Long cinemaId,
                           Address address,
                           Set<Movie> repertoire) {}
