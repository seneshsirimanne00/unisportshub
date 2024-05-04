package com.sportsevents.manager.DTO.RequestDTO;

import com.sportsevents.manager.DTO.CommonDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResultRequestDTO extends CommonDTO {

    private Long teamAId;
    private Long teamBId;
    private Long teamAScore;
    private Long teamBScore;
    private List<String> achievements;
    private Long sportId;
    private Long eventId;


}
