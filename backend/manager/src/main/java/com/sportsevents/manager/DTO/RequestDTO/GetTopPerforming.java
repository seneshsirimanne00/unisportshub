package com.sportsevents.manager.DTO.RequestDTO;

import lombok.Data;

@Data
public class GetTopPerforming {

    private Long userId;
    private Long start;
    private Long end;
}
