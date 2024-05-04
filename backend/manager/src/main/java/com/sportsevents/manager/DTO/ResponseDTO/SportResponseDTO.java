package com.sportsevents.manager.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SportResponseDTO {

    private String name;
    private Long sportId;
    private List<EventResponseDTO> events;
    private Long ranking;

}
