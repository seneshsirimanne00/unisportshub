package com.sportsevents.manager.DTO.ResponseDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthSuccessResponseDTO {

    private final String response = "SUCCESS";
    private Long userId;

}
