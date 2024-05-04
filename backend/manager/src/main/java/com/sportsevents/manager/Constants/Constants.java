package com.sportsevents.manager.Constants;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class Constants {

    public static List<Long> adminList = new ArrayList<>();
    public static final String USER_ID = "userId";
    public static final Long CRICKET = 1L;
    public static final Long SPORTS_CLUB_CODE = 2L;
    public static final Long SPORTS_COUNCIL_CODE = 3L;
    public static final Long STUDENT_CODE = 4L;
    public static final Long ATHLETE_CODE = 5L;
    public static final String IS_FINISHED = "isFinished";
    public static final Long TOURNAMENT = 8L;
    public static final Long FRIENDLY_MATCH = 9L;
    public static final List<Long> ACCESS_LIST_ONLY_ADMIN = getAdminAccess();
    public static final List<Long> ACCESS_LIST_ADMIN_CLUB = getAdminAndSportsClubAccess();
    public static final List<Long> ACCESS_LIST_ONLY_CLUB = getSportsClubAccess();


    public static List<Long> getAdminAccess(){
        adminList.add(SPORTS_COUNCIL_CODE);
        return adminList;
    }

    public static List<Long> getAdminAndSportsClubAccess(){
        adminList.add(SPORTS_COUNCIL_CODE);
        adminList.add(SPORTS_CLUB_CODE);
        return adminList;
    }

    public static List<Long> getSportsClubAccess(){
        adminList.add(SPORTS_CLUB_CODE);
        return adminList;
    }
//    public static final String IS_FINISHED = "isFinished";
//    public static final Long CRICKET = 1L;


}
