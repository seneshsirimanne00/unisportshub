package com.sportsevents.manager.DTO.ResponseDTO;

import com.sportsevents.manager.DTO.CommonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponseDTO extends CommonDTO {

    private SportClubResponseDTO teamA;
    private SportClubResponseDTO teamB;
    private Long teamAScore;
    private Long teamBScore;
    private List<String> achievements;
    private SportResponseDTO sportType;
    private EventResponseDTO event;

}
