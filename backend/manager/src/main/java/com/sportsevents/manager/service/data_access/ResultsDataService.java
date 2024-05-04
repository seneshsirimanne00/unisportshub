package com.sportsevents.manager.service.data_access;

import com.sportsevents.manager.DTO.RequestDTO.GetResultsBySportsClubAndSportRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.ResultRequestDTO;
import com.sportsevents.manager.Entity.Results;

import java.util.List;

public interface ResultsDataService {

    Results createResults(ResultRequestDTO requestDTO);

    Results getById(Long id);

    List<Results> getBySportId(Long id);

    List<Results> getAllBySportClubAndType(GetResultsBySportsClubAndSportRequestDTO requestDTO);

    List<Results> getALl();

    Results findByEventId(Long id);

    Results updateResults(ResultRequestDTO requestDTO, Long id);

}
