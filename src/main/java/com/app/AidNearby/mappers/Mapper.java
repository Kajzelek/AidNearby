package com.app.AidNearby.mappers;

public interface Mapper<A, B> {
    B mapToDto(A a);

    A mapToEntity(B b);
}

