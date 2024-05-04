package com.sportsevents.manager.DTO.RequestDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetEventDateBetweenRequestDTO {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
