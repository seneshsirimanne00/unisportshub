package com.sportsevents.manager.Mapper;

import com.sportsevents.manager.DTO.RequestDTO.ResultRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.ResultResponseDTO;
import com.sportsevents.manager.Entity.Results;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResultsMapper {

    ResultsMapper INSTANCE = Mappers.getMapper(ResultsMapper.class);

    @Mapping(target = "achievements", ignore = true)
    Results resultsRequestDtoToEntity(ResultRequestDTO requestDTO);

    @Mapping(target = "achievements", ignore = true)
    ResultResponseDTO resultsToResultResponseDTO(Results results);

    @Mapping(target = "achievements", ignore = true)
    void updateResultsEntity(ResultRequestDTO source, @MappingTarget Results target);

}
