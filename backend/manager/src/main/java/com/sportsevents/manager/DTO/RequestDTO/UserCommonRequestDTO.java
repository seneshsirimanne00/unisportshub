package com.sportsevents.manager.DTO.RequestDTO;

import com.sportsevents.manager.DTO.CommonDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserCommonRequestDTO extends CommonDTO {

    private String username;
    private String password;
    private String email;
    private Long userId;
    private String name;

}
