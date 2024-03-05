package org.cqrs.cinema;

import java.util.Set;

record MovieProjection(String title,
                       Set<Actor> actors,
                       Set<Review> reviews) {}
