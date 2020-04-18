package com.example.homeworkbackend.sites;

import com.example.homeworkbackend.common.DTOMapper;
import org.springframework.stereotype.Component;

@Component
public class SiteMapper implements DTOMapper<SiteEntity, SiteDTO> {

    @Override
    public SiteEntity dtoToEntity(SiteDTO dto) {
        if (dto == null){
            return null;
        }

        return SiteEntity.builder()
                .zip(dto.getZip())
                .city(dto.getCity())
                .street(dto.getStreet())
                .houseNumber(dto.getHouseNumber())
                .build();

    }

    @Override
    public SiteDTO entityToDTO(SiteEntity entity) {
        if (entity == null) {
            return null;
        }

        return SiteDTO.builder()
                .id(entity.getId())
                .zip(entity.getZip())
                .city(entity.getCity())
                .street(entity.getStreet())
                .houseNumber(entity.getHouseNumber())
                .build();
    }
}
