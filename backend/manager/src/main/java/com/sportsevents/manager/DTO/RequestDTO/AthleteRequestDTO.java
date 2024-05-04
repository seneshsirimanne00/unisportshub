package com.sportsevents.manager.DTO.RequestDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AthleteRequestDTO extends UserCommonRequestDTO{

    private Long position;
    private List<String> achievements;

}
