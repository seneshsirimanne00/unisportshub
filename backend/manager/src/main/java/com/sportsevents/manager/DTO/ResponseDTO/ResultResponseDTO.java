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

    private Long teamAId;
    private Long teamBId;
    private Long teamAScore;
    private Long teamBScore;
    private String teamAName;
    private String teamBName;
    private List<String> achievements;
    private Long sportId;
    private Long eventId;

}
