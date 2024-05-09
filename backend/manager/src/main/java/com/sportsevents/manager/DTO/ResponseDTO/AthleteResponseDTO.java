package com.sportsevents.manager.DTO.ResponseDTO;

import com.sportsevents.manager.DTO.UserCommonResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteResponseDTO extends UserCommonResponseDTO {

    private Long position;
    private List<String> achievements;
    private Long clubId;

}
