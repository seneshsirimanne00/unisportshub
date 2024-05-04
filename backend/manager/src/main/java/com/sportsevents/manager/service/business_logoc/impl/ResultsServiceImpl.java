package com.sportsevents.manager.service.business_logoc.impl;

import com.sportsevents.manager.DTO.RequestDTO.GetResultsBySportsClubAndSportRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.ResultRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.ResultResponseDTO;
import com.sportsevents.manager.Entity.Results;
import com.sportsevents.manager.Mapper.ResultsMapper;
import com.sportsevents.manager.service.business_logoc.ResultsService;
import com.sportsevents.manager.service.data_access.ResultsDataService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultsServiceImpl implements ResultsService {

    private final ResultsDataService resultsDataService;

    @Override
    public ResultResponseDTO createResult(ResultRequestDTO requestDTO) {
        Results results = resultsDataService.createResults(requestDTO);
        ResultResponseDTO responseDTO =  ResultsMapper.INSTANCE.resultsToResultResponseDTO(results);
        resultToResponseDTO(results, responseDTO);
        return responseDTO;
    }

    @Override
    public ResultResponseDTO getById(Long id) {
        Results results = resultsDataService.getById(id);
        ResultResponseDTO responseDTO =  ResultsMapper.INSTANCE.resultsToResultResponseDTO(results);
        resultToResponseDTO(results, responseDTO);
        return responseDTO;
    }

    @Override
    public List<ResultResponseDTO> getAllBySportType(Long id) {
        List<Results> results = resultsDataService.getBySportId(id);
        if (!results.isEmpty()){
            List<ResultResponseDTO> resultResponseDTO = results.stream().map(ResultsMapper.INSTANCE::resultsToResultResponseDTO).toList();
            resultListToResponseDTOList(results, resultResponseDTO);
            return resultResponseDTO;
        }
        return null;
    }

    @Override
    public List<ResultResponseDTO> getAllBySportClubAndType(GetResultsBySportsClubAndSportRequestDTO requestDTO) {
        List<Results> results = resultsDataService.getAllBySportClubAndType(requestDTO);
        if (!results.isEmpty()){
            List<ResultResponseDTO> resultResponseDTO = results.stream().map(ResultsMapper.INSTANCE::resultsToResultResponseDTO).toList();
            resultListToResponseDTOList(results, resultResponseDTO);
            return resultResponseDTO;
        }
        return null;
    }

    @Override
    public List<ResultResponseDTO> getALl() {
        List<Results> results = resultsDataService.getALl();
        if (!results.isEmpty()){
            List<ResultResponseDTO> resultResponseDTO = results.stream().map(ResultsMapper.INSTANCE::resultsToResultResponseDTO).toList();
            resultListToResponseDTOList(results, resultResponseDTO);
            return resultResponseDTO;
        }
        return null;
    }

    @Override
    public ResultResponseDTO updateEvent(ResultRequestDTO requestDTO, Long id) {
        Results results = resultsDataService.updateResults(requestDTO, id);
        ResultResponseDTO responseDTO =  ResultsMapper.INSTANCE.resultsToResultResponseDTO(results);
        resultToResponseDTO(results, responseDTO);
        return responseDTO;
    }

    public List<String> stringToList(String strList){
        if (!StringUtils.isBlank(strList)){
            return Arrays.asList(strList.split(","));
        }
        return null;
    }
    public void resultToResponseDTO(Results result, ResultResponseDTO resultResponseDTO){
        System.out.println("-----------------------------------------");
        System.out.println(result.getAchievements());
        System.out.println(stringToList(result.getAchievements()));
        resultResponseDTO.setAchievements(stringToList(result.getAchievements()));
    }

    public void resultListToResponseDTOList(List<Results> results, List<ResultResponseDTO> resultResponseDTOS){
        for (int i = 0; i < results.size(); i++){
            resultToResponseDTO(results.get(i), resultResponseDTOS.get(i));
        }
    }
}
