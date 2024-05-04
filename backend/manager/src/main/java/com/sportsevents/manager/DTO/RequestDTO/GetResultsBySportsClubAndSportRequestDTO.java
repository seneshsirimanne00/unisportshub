package com.sportsevents.manager.DTO.RequestDTO;

import lombok.Data;

@Data
public class GetResultsBySportsClubAndSportRequestDTO {

    private Long sportsClubId;
    private Long sportId;

}
