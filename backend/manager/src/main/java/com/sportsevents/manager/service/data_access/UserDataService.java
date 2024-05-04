package com.sportsevents.manager.service.data_access;

import com.sportsevents.manager.DTO.RequestDTO.*;
import com.sportsevents.manager.Entity.User;

import java.util.List;

public interface UserDataService {

    User saveStudent(StudentRequestDTO requestDTO);

    User saveSportsClub(SportsClubRequestDTO requestDTO);

    User saveSportsCouncil(SportsCouncilRequestDTO requestDTO);

    User saveAthlete(AthleteRequestDTO requestDTO);

    User getUserById(Long id);

    List<User> getAllStudents();

    List<User> getAllSportsClubs();

    List<User> getAllSportsCouncils();

    List<User> getAllAthletes();

    User updateSportsClub(SportsClubRequestDTO requestDTO, Long id);

    User updateSportsCouncil(SportsCouncilRequestDTO requestDTO, Long id);

    User updateAthlete(AthleteRequestDTO requestDTO, Long id);

    User updateStudent(StudentRequestDTO requestDTO, Long id);

    List<User> getTopPerformingTeams(GetTopPerforming getTopPerforming);

    List<User> getAllClubsPositionAscending(Long id);

}
