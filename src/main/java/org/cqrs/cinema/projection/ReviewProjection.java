package org.cqrs.cinema.projection;

public record ReviewProjection(String description,
                               int rating) {}
