package org.cqrs.cinema.projection;

public record AddressProjection(String city,
                                String street,
                                String postalCode) {}
