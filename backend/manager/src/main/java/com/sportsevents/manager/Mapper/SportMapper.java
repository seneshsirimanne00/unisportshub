package com.sportsevents.manager.Mapper;

import com.sportsevents.manager.Entity.Sport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SportMapper {

    SportMapper INSTANCE = Mappers.getMapper(SportMapper.class);

    Sport entityToResponseDTO(Sport sport);

}
