package org.cqrs.cinema;

import java.time.LocalDateTime;
import java.util.Set;

record Cinema(Long cinemaId,
              Address address,
              Set<Movie> repertoire) {}

record Address(String city,
               String street,
               String postalCode) {}

record Movie(Long filmId,
             String title,
             LocalDateTime releaseDate,
             Long duration,
             Set<Actor> actors,
             Set<Review> reviews) {}

record Actor(String name,
             String surname) {}

record Review(String description,
              int rating) {}