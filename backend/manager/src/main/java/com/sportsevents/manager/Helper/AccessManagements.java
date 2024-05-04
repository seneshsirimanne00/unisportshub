package com.sportsevents.manager.Helper;

import java.util.List;
import java.util.Objects;

public class AccessManagements {

    public static Boolean hasAccess(Long userId, List<Long> hasAccessList){
        for (Long accessId: hasAccessList){
            if (Objects.equals(userId, accessId)){
                return true;
            }
        }
        return false;
    }

}
