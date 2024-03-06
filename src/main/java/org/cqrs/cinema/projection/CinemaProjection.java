package org.cqrs.cinema.projection;

import java.util.Set;

public record CinemaProjection(Long cinemaId,
                               AddressProjection address,
                               Set<MovieProjection> repertoire) {}
