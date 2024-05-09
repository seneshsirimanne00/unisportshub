package com.sportsevents.manager.DTO.RequestDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SportsClubRequestDTO extends UserCommonRequestDTO {

    List<String> achievements;
    String logoBase64;
    String basicInfo;
    Long winnings;
    Long losses;

}
