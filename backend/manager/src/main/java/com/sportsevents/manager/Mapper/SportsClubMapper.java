package com.sportsevents.manager.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SportsClubMapper {

    SportsClubMapper INSTANCE = Mappers.getMapper(SportsClubMapper.class);

}
