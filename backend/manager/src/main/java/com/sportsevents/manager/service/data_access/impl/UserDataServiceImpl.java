package com.sportsevents.manager.service.data_access.impl;

import com.sportsevents.manager.DTO.RequestDTO.*;
import com.sportsevents.manager.Entity.User;
import com.sportsevents.manager.Mapper.UserMapper;
import com.sportsevents.manager.repository.UserRepository;
import com.sportsevents.manager.service.data_access.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.sportsevents.manager.Constants.Constants.*;

@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {

    private final UserRepository userRepository;

    @Override
    public User saveStudent(StudentRequestDTO requestDTO) {
        return userRepository.save(UserMapper.INSTANCE.studentRequestDtoToUser(requestDTO));
    }

    @Override
    public User saveSportsClub(SportsClubRequestDTO requestDTO) {
        User user = UserMapper.INSTANCE.sportsClubRequestDtoToUser(requestDTO);
        user.setAchievements(convertToString(requestDTO.getAchievements()));
        return userRepository.save(user);
    }

    @Override
    public User saveSportsCouncil(SportsCouncilRequestDTO requestDTO) {
        return userRepository.save(UserMapper.INSTANCE.sportsCouncilRequestDtoToUser(requestDTO));
    }

    @Override
    public User saveAthlete(AthleteRequestDTO requestDTO) {
        User user = UserMapper.INSTANCE.athleteRequestDtoToUser(requestDTO);
        user.setAchievements(convertToString(requestDTO.getAchievements()));
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<User> getAllStudents() {
        return userRepository.findAllByUserId(STUDENT_CODE); //todo: set properly
    }

    @Override
    public List<User> getAllSportsClubs() {
        return userRepository.findAllByUserId(SPORTS_CLUB_CODE); //todo: set properly
    }

    @Override
    public List<User> getAllSportsCouncils() {
        return userRepository.findAllByUserId(SPORTS_COUNCIL_CODE); //todo: set properly
    }

    @Override
    public List<User> getAllAthletes() {
        return userRepository.findAllByUserId(ATHLETE_CODE); //todo: set properly
    }

    @Override
    public User updateSportsClub(SportsClubRequestDTO requestDTO, Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            UserMapper.INSTANCE.updateSportsClub(requestDTO, user.get());
//            List<String> currentAchievements = Arrays.asList(user.get().getAchievements().split(","));
            user.get().setAchievements(convertToString(requestDTO.getAchievements()));
            return userRepository.save(user.get());
        }
        return null;
    }

    @Override
    public User updateSportsCouncil(SportsCouncilRequestDTO requestDTO, Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            UserMapper.INSTANCE.updateSportsCouncil(requestDTO, user.get());
            return userRepository.save(user.get());
        }
        return null;
    }

    @Override
    public User updateAthlete(AthleteRequestDTO requestDTO, Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            UserMapper.INSTANCE.updateAthlete(requestDTO, user.get());
//            List<String> currentAchievements = Arrays.asList(user.get().getAchievements().split(","));
            user.get().setAchievements(convertToString(requestDTO.getAchievements()));
            return userRepository.save(user.get());
        }
        return null;
    }

    @Override
    public User updateStudent(StudentRequestDTO requestDTO, Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            UserMapper.INSTANCE.updateStudent(requestDTO, user.get());
            return userRepository.save(user.get());
        }
        return null;
    }

    @Override
    public List<User> getTopPerformingAthletes(GetTopPerformingRequestDTO getTopPerformingRequestDTO) {
        return userRepository.findAllByUserIdAndPositionBetween(ATHLETE_CODE, getTopPerformingRequestDTO.getStart(), getTopPerformingRequestDTO.getEnd());
    }

    @Override
    public List<User> getTopPerformingTeams(GetTopPerformingRequestDTO getTopPerformingRequestDTO) {
        return userRepository.findAllByUserIdAndWinningsBetween(getTopPerformingRequestDTO.getUserId(), getTopPerformingRequestDTO.getStart(), getTopPerformingRequestDTO.getEnd());
    }

    @Override
    public List<User> getAllClubsPositionAscending(Long id) {
        return userRepository.findAllByUserIdOrderByWinnings(id);
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.getByUsername(username);
        return user.orElse(null);
    }

    private String convertToString(List<String> stringList){
        if (!(stringList == null || stringList.isEmpty())){
            return stringList.toString();
        }
        return null;
    }


}
