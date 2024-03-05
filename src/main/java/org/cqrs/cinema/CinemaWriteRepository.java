package org.cqrs.cinema;

import java.util.HashMap;
import java.util.Map;

class CinemaWriteRepository {

    final Map<Long, Cinema> cinemaStore = new HashMap<>();

    Cinema putNewCinema(Cinema cinema) {
        cinemaStore.put(cinema.cinemaId(), cinema);
        return cinemaStore.get(cinema.cinemaId());
    }
}
