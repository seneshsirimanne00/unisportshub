package com.sportsevents.manager.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonDTO {

    private Long id;

    public Long getId(){
        return id;
    }

}
