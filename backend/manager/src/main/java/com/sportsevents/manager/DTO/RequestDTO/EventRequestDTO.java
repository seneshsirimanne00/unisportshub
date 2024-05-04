package com.sportsevents.manager.DTO.RequestDTO;

import com.sportsevents.manager.DTO.CommonDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class EventRequestDTO extends CommonDTO {

    private Long eventId; //eventType
    private String name;
    private String description;
    private List<String> eligibilityDetails;
    private List<String> participationGuidelines;
    private List<String> registrationProcedure;
    private LocalDateTime eventDate;
    private List<Long> playersIdList;//todo: handle this
    private Long teamA;
    private Long teamB;
    private Long sportId;



}
