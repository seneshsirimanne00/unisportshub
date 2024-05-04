package com.sportsevents.manager.DTO.RequestDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetEventDateBetweenAndEventTypeRequestDTO {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long eventId;

}
