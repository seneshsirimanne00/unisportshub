package com.sportsevents.manager.DTO.ResponseDTO;

import com.sportsevents.manager.DTO.CommonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDTO extends CommonDTO {

    private Long eventId; //eventType
    private String name;
    private String description;
    private List<String> eligibilityDetails;
    private List<String> participationGuidelines;
    private List<String> registrationProcedure;
    private LocalDateTime eventDate;
    private List<Long> playersIdList;
    private Long clubId;
    private Long sportId;
    private Long teamA;
    private Long teamB;

}
