package com.example.homeworkbackend.common;

public interface DTOMapper<E, D> {

    E dtoToEntity(D dto);

    D entityToDTO(E entity);
}
