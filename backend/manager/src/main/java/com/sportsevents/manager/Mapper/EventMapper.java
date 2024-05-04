package com.sportsevents.manager.Mapper;

import com.sportsevents.manager.DTO.RequestDTO.EventRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.EventResponseDTO;
import com.sportsevents.manager.Entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(target = "eligibilityDetails", ignore = true)
    @Mapping(target = "participationGuidelines", ignore = true)
    @Mapping(target = "registrationProcedure", ignore = true)
    Event eventRequestDtoToEntity(EventRequestDTO requestDTO);


    @Mapping(target = "eligibilityDetails", ignore = true)
    @Mapping(target = "participationGuidelines", ignore = true)
    @Mapping(target = "registrationProcedure", ignore = true)
    EventResponseDTO eventToEventResponseDTO(Event event);

    @Mapping(target = "eligibilityDetails", ignore = true)
    @Mapping(target = "participationGuidelines", ignore = true)
    @Mapping(target = "registrationProcedure", ignore = true)
    void updateEventEntity(EventRequestDTO source, @MappingTarget Event target);


}
