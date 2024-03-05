package org.cqrs.cinema;

import java.util.Set;

record CinemaProjection(Long cinemaId,
                        Address address,
                        Set<Movie> repertoire) {}
