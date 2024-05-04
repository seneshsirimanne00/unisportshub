package com.sportsevents.manager.service.business_logoc;

import com.sportsevents.manager.DTO.RequestDTO.GetResultsBySportsClubAndSportRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.ResultRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.ResultResponseDTO;

import java.util.List;

public interface ResultsService {

    ResultResponseDTO createResult(ResultRequestDTO requestDTO);

    ResultResponseDTO getById(Long id);

    List<ResultResponseDTO> getAllBySportType(Long id); //no need

    List<ResultResponseDTO> getAllBySportClubAndType(GetResultsBySportsClubAndSportRequestDTO requestDTO);

    List<ResultResponseDTO> getALl(); //

    ResultResponseDTO updateEvent(ResultRequestDTO requestDTO, Long id);

    //todo: get by sport Id

}
