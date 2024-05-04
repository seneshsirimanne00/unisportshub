package com.sportsevents.manager.DTO.RequestDTO;

import lombok.Data;

@Data
public class GetAllEventsBySportClubAndIsFinished {

    private Long sportLClubId;
    private Boolean isFinished;

}


