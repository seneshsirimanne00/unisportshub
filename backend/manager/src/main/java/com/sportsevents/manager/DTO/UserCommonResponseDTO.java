package com.sportsevents.manager.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommonResponseDTO extends CommonDTO{

    private String name;
    private Long userId;
    private String email;
    private String username;

}
