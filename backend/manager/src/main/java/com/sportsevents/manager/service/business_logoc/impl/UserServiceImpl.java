package com.sportsevents.manager.service.business_logoc.impl;

import com.sportsevents.manager.DTO.RequestDTO.*;
import com.sportsevents.manager.DTO.ResponseDTO.*;
import com.sportsevents.manager.Entity.User;
import com.sportsevents.manager.Mapper.UserMapper;
import com.sportsevents.manager.service.business_logoc.UserService;
import com.sportsevents.manager.service.data_access.UserDataService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.sportsevents.manager.Constants.Constants.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDataService userDataService;


    @Override
    public AuthSuccessResponseDTO authenticateUser(LoginRequestDTO requestDTO) {
        User user = userDataService.getUserByUsername(requestDTO.getUsername());
        if (user != null){
            if (user.getPassword().equals(requestDTO.getPassword())){
                AuthSuccessResponseDTO responseDTO = new AuthSuccessResponseDTO();
                responseDTO.setUserId(user.getUserId());
                responseDTO.setId(user.getId());
                return responseDTO;
            }
        }
        return null;
    }

    @Override
    public StudentResponseDTO saveStudent(StudentRequestDTO requestDTO) {
        requestDTO.setUserId(STUDENT_CODE);
        return UserMapper.INSTANCE.userEntityToStudentResDTO(userDataService.saveStudent(requestDTO));
    }

    @Override
    public SportClubResponseDTO saveSportsClub(SportsClubRequestDTO requestDTO) {
        requestDTO.setUserId(SPORTS_CLUB_CODE);
        User user = userDataService.saveSportsClub(requestDTO);
        SportClubResponseDTO responseDTO = UserMapper.INSTANCE.userEntityToSportClubResDTO(user);
        userToSportsClubResponseDTO(user, responseDTO);
        return responseDTO;
    }

    @Override
    public SportsCouncilResponseDTO saveSportsCouncil(SportsCouncilRequestDTO requestDTO) {
        requestDTO.setUserId(SPORTS_COUNCIL_CODE);
        return UserMapper.INSTANCE.userEntityToSportsCouncilResDTO(userDataService.saveSportsCouncil(requestDTO));
    }

    @Override
    public AthleteResponseDTO saveAthlete(AthleteRequestDTO requestDTO) {
        requestDTO.setUserId(ATHLETE_CODE);
        User user = userDataService.saveAthlete(requestDTO);
        AthleteResponseDTO athleteResponseDTO = UserMapper.INSTANCE.userEntityToAthleteResDTO(user);
        userToAthleteResponseDTO(user, athleteResponseDTO);
        return athleteResponseDTO;
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        return UserMapper.INSTANCE.userEntityToStudentResDTO(userDataService.getUserById(id));
    }

    @Override
    public SportClubResponseDTO getSportClubById(Long id) {
        User user = userDataService.getUserById(id);
        SportClubResponseDTO sportClubResponseDTO = UserMapper.INSTANCE.userEntityToSportClubResDTO(user);
        userToSportsClubResponseDTO(user, sportClubResponseDTO);
        return sportClubResponseDTO;
    }

    @Override
    public SportsCouncilResponseDTO getSportCouncilById(Long id) {
        return UserMapper.INSTANCE.userEntityToSportsCouncilResDTO(userDataService.getUserById(id));
    }

    @Override
    public AthleteResponseDTO getAthleteById(Long id) {
        User user = userDataService.getUserById(id);
        AthleteResponseDTO athleteResponseDTO = UserMapper.INSTANCE.userEntityToAthleteResDTO(user);
        userToAthleteResponseDTO(user, athleteResponseDTO);
        return athleteResponseDTO;
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<User> users = userDataService.getAllStudents();
        return users.stream().map(UserMapper.INSTANCE::userEntityToStudentResDTO).toList();
    }

    @Override
    public List<SportClubResponseDTO> getAllSportsClubs() {
        List<User> users = userDataService.getAllSportsClubs();
        if (!users.isEmpty()){
            List<SportClubResponseDTO> sportClubResponseDTOS = users.stream().map(UserMapper.INSTANCE::userEntityToSportClubResDTO).toList();
            userListToSportsClubResponseDTOList(users, sportClubResponseDTOS);
            return sportClubResponseDTOS;
        }
        return null;
    }

    @Override
    public List<SportsCouncilResponseDTO> getAllSportsCouncils() {
        List<User> users = userDataService.getAllSportsCouncils();
        return users.stream().map(UserMapper.INSTANCE::userEntityToSportsCouncilResDTO).toList();
    }

    @Override
    public List<AthleteResponseDTO> getAllAthletes() {
        List<User> users = userDataService.getAllAthletes();
        if (!users.isEmpty()){
            List<AthleteResponseDTO> athleteResponseDTOS = users.stream().map(UserMapper.INSTANCE::userEntityToAthleteResDTO).toList();
            userListToAthleteResponseDTOList(users, athleteResponseDTOS);
            return athleteResponseDTOS;
        }
        return null;
    }

    @Override
    public SportClubResponseDTO updateSportsClub(SportsClubRequestDTO requestDTO, Long id) {
        User user = userDataService.updateSportsClub(requestDTO, id);
        SportClubResponseDTO sportClubResponseDTO = UserMapper.INSTANCE.userEntityToSportClubResDTO(user);
        userToSportsClubResponseDTO(user, sportClubResponseDTO);
        return sportClubResponseDTO;
    }

    @Override
    public SportsCouncilResponseDTO updateSportsCouncil(SportsCouncilRequestDTO requestDTO, Long id) {
        return UserMapper.INSTANCE.userEntityToSportsCouncilResDTO(userDataService.updateSportsCouncil(requestDTO, id));
    }

    @Override
    public AthleteResponseDTO updateAthlete(AthleteRequestDTO requestDTO, Long id) {
        User user = userDataService.updateAthlete(requestDTO, id);
        AthleteResponseDTO athleteResponseDTO = UserMapper.INSTANCE.userEntityToAthleteResDTO(user);
        userToAthleteResponseDTO(user, athleteResponseDTO);
        return athleteResponseDTO;
    }

    @Override
    public StudentResponseDTO updateStudent(StudentRequestDTO requestDTO, Long id) {
        return UserMapper.INSTANCE.userEntityToStudentResDTO(userDataService.updateStudent(requestDTO, id));
    }

    @Override
    public List<AthleteResponseDTO> getTopPerformingAthletes(GetTopPerformingRequestDTO getTopPerformingRequestDTO) {
        List<User> users = userDataService.getTopPerformingAthletes(getTopPerformingRequestDTO);
        if (!users.isEmpty()){
            List<AthleteResponseDTO> athleteResponseDTO = users.stream().map(UserMapper.INSTANCE::userEntityToAthleteResDTO).toList();
            userListToAthleteResponseDTOList(users, athleteResponseDTO);
            return athleteResponseDTO;
        }
        return null;
    }

    @Override
    public List<SportClubResponseDTO> getTopPerformingTeams(GetTopPerformingRequestDTO getTopPerformingRequestDTO) {
        List<User> users = userDataService.getTopPerformingTeams(getTopPerformingRequestDTO);
        if (!users.isEmpty()){
            List<SportClubResponseDTO> sportClubResponseDTOS = users.stream().map(UserMapper.INSTANCE::userEntityToSportClubResDTO).toList();
            userListToSportsClubResponseDTOList(users, sportClubResponseDTOS);
            return sportClubResponseDTOS;
        }
        return null;
    }

    @Override
    public List<SportClubResponseDTO> getAllPositionAscending(Long id) {
        List<User> users = userDataService.getAllClubsPositionAscending(id);
        if (!users.isEmpty()){
            List<SportClubResponseDTO> sportClubResponseDTOS = users.stream().map(UserMapper.INSTANCE::userEntityToSportClubResDTO).toList();
            userListToSportsClubResponseDTOList(users, sportClubResponseDTOS);
            return sportClubResponseDTOS;
        }
        return null;
    }

    @Override
    public List<AthleteResponseDTO> getAllAthletePositionAscending(Long id) {
        List<User> users = userDataService.getAllClubsPositionAscending(id);
        if (!users.isEmpty()){
            List<AthleteResponseDTO> athleteResponseDTOS = users.stream().map(UserMapper.INSTANCE::userEntityToAthleteResDTO).toList();
            userListToAthleteResponseDTOList(users, athleteResponseDTOS);
            return athleteResponseDTOS;
        }
        return null;
    }



    public List<String> stringToList(String strList){
        if (!StringUtils.isBlank(strList)){
            strList = strList.replace("[", "").replace("]","");
            return Arrays.asList(strList.split(","));
        }
        return null;
    }

    public void userToAthleteResponseDTO(User athlete, AthleteResponseDTO athleteResponseDTO){
        athleteResponseDTO.setAchievements(stringToList(athlete.getAchievements()));
    }

    public void userListToAthleteResponseDTOList(List<User> athlete, List<AthleteResponseDTO> athleteResponseDTOS){
        for (int i = 0; i < athlete.size(); i++){
            userToAthleteResponseDTO(athlete.get(i), athleteResponseDTOS.get(i));
        }
    }

    public void userToSportsClubResponseDTO(User sportsClub, SportClubResponseDTO sportClubResponseDTO){
        sportClubResponseDTO.setAchievements(stringToList(sportsClub.getAchievements()));
    }

    public void userListToSportsClubResponseDTOList(List<User> sportsClub, List<SportClubResponseDTO> sportClubResponseDTOS){
        for (int i = 0; i < sportsClub.size(); i++){
            userToSportsClubResponseDTO(sportsClub.get(i), sportClubResponseDTOS.get(i));
        }
    }
}
