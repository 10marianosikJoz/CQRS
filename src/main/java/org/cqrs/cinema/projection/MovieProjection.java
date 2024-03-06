package org.cqrs.cinema.projection;

import java.util.Set;

public record MovieProjection(String title,
                              Set<ActorProjection> actors,
                              Set<ReviewProjection> reviews) {}
