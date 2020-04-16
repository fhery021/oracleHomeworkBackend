package com.example.homeworkbackend.common;

public interface RequestResponseMapper<E, K, L> {

    L entityToResponse(E entity);

    E requestToEntity(K request);
}
