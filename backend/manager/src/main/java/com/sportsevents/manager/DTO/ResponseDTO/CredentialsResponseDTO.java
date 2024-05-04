package com.sportsevents.manager.DTO.ResponseDTO;

import com.sportsevents.manager.DTO.CommonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialsResponseDTO extends CommonDTO {

    private String username;
    private String password;
    private Long userId;

}
