package com.sportsevents.manager.DTO.ResponseDTO;

import com.sportsevents.manager.DTO.UserCommonResponseDTO;
import com.sportsevents.manager.Entity.Results;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SportClubResponseDTO extends UserCommonResponseDTO {

    List<AthleteResponseDTO> players;
    List<Results> stats;
    List<String> achievements;
    String logoBase64;
    String basicInfo;

}
