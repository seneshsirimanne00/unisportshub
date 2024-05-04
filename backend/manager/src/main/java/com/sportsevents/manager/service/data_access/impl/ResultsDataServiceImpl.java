package com.sportsevents.manager.service.data_access.impl;

import com.sportsevents.manager.DTO.RequestDTO.GetResultsBySportsClubAndSportRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.ResultRequestDTO;
import com.sportsevents.manager.Entity.Results;
import com.sportsevents.manager.Mapper.ResultsMapper;
import com.sportsevents.manager.repository.ResultsRepository;
import com.sportsevents.manager.repository.SportRepository;
import com.sportsevents.manager.repository.UserRepository;
import com.sportsevents.manager.service.data_access.ResultsDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.sportsevents.manager.Constants.Constants.CRICKET;

@Service
@RequiredArgsConstructor
public class ResultsDataServiceImpl implements ResultsDataService {

    private final ResultsRepository resultsRepository;
    private final SportRepository sportRepository;
    private final UserRepository userRepository;

    @Override
    public Results createResults(ResultRequestDTO requestDTO) {
        Results results = ResultsMapper.INSTANCE.resultsRequestDtoToEntity(requestDTO);
        results.setAchievements(requestDTO.getAchievements().toString());
        results.setSportId(CRICKET);
        return resultsRepository.save(results);
    }

    @Override
    public Results getById(Long id) {
        Optional<Results> results = resultsRepository.findById(id);
        return results.orElse(null);

    }



    @Override
    public List<Results> getBySportId(Long id) {
        return resultsRepository.findAllBySportIdOrderById(id);
    }

    @Override
    public List<Results> getAllBySportClubAndType(GetResultsBySportsClubAndSportRequestDTO requestDTO) {
        return resultsRepository.findAllByTeamAIdAndTeamBIdAndSportId(requestDTO.getSportsClubId(), requestDTO.getSportsClubId(), CRICKET);
    }

    @Override
    public List<Results> getALl() {
        return resultsRepository.findAll();
    }

    @Override
    public Results findByEventId(Long id) {
        Optional<Results> result = resultsRepository.findByEventId(id);
        return result.orElse(null);

    }


    @Override
    public Results updateResults(ResultRequestDTO requestDTO, Long id) {
        Optional<Results> result = resultsRepository.findById(id);
        if (result.isPresent()){
            ResultsMapper.INSTANCE.updateResultsEntity(requestDTO, result.get());
            List<String> currentAchievements = Arrays.asList(result.get().getAchievements().split(","));
            result.get().setAchievements((Stream.concat(currentAchievements.stream(), requestDTO.getAchievements().stream()).toList()).toString());
            return resultsRepository.save(result.get());
        }else {
            return null;
        }
    }
}
