package com.sportsevents.manager.service.business_logoc;

import com.sportsevents.manager.DTO.RequestDTO.*;
import com.sportsevents.manager.DTO.ResponseDTO.AthleteResponseDTO;
import com.sportsevents.manager.DTO.ResponseDTO.SportClubResponseDTO;
import com.sportsevents.manager.DTO.ResponseDTO.SportsCouncilResponseDTO;
import com.sportsevents.manager.DTO.ResponseDTO.StudentResponseDTO;

import java.util.List;

public interface UserService {

    StudentResponseDTO saveStudent(StudentRequestDTO requestDTO);

    SportClubResponseDTO saveSportsClub(SportsClubRequestDTO requestDTO);

    SportsCouncilResponseDTO saveSportsCouncil(SportsCouncilRequestDTO requestDTO);

    AthleteResponseDTO saveAthlete(AthleteRequestDTO requestDTO);

    StudentResponseDTO getStudentById(Long id);

    SportClubResponseDTO getSportClubById(Long id);

    SportsCouncilResponseDTO getSportCouncilById(Long id);

    AthleteResponseDTO getAthleteById(Long id);

    List<StudentResponseDTO> getAllStudents();

    List<SportClubResponseDTO> getAllSportsClubs();

    List<SportsCouncilResponseDTO> getAllSportsCouncils();

    List<AthleteResponseDTO> getAllAthletes();

    SportClubResponseDTO updateSportsClub(SportsClubRequestDTO requestDTO, Long id);

    SportsCouncilResponseDTO updateSportsCouncil(SportsCouncilRequestDTO requestDTO, Long id);

    AthleteResponseDTO updateAthlete(AthleteRequestDTO requestDTO, Long id);

    StudentResponseDTO updateStudent(StudentRequestDTO requestDTO, Long id);

    List<AthleteResponseDTO> getTopPerformingTeams(GetTopPerforming getTopPerforming);

    List<SportClubResponseDTO> getAllPositionAscending(Long id);

}
