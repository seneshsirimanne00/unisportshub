package com.sportsevents.manager.Mapper;

import com.sportsevents.manager.DTO.RequestDTO.AthleteRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.SportsClubRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.SportsCouncilRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.StudentRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.*;
import com.sportsevents.manager.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "achievements", ignore = true)
    AthleteResponseDTO userEntityToAthleteResDTO(User user);

    CredentialsResponseDTO userEntityToCredentialsResDTO(User user);

//    @Mapping(target = "logoBase64", source = "clubDetails.logoBase64")
//    @Mapping(target = "basicInfo", source = "clubDetails.basicInfo")
    @Mapping(target = "achievements", ignore = true)
    SportClubResponseDTO userEntityToSportClubResDTO(User user);

    SportsCouncilResponseDTO userEntityToSportsCouncilResDTO(User user);

    StudentResponseDTO userEntityToStudentResDTO(User user);

    User studentRequestDtoToUser(StudentRequestDTO requestDTO);

    @Mapping(target = "achievements", ignore = true)
    User athleteRequestDtoToUser(AthleteRequestDTO requestDTO);

    User sportsCouncilRequestDtoToUser(SportsCouncilRequestDTO requestDTO);

    @Mapping(target = "achievements", ignore = true)
    User sportsClubRequestDtoToUser(SportsClubRequestDTO requestDTO);

    void updateStudent(StudentRequestDTO source, @MappingTarget User target);
    void updateSportsCouncil(SportsCouncilRequestDTO source, @MappingTarget User target);
    @Mapping(target = "achievements", ignore = true)
    void updateSportsClub(SportsClubRequestDTO source, @MappingTarget User target);
    @Mapping(target = "achievements", ignore = true)
    void updateAthlete(AthleteRequestDTO source, @MappingTarget User target);



}
