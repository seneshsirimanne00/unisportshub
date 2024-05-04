package com.sportsevents.manager.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

//@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "application_user")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    //GENERAL USER DETAILS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Long userId;
    private String email;//todo: add validation
    private String username;
    private String password;
    //CLUB AND ATHLETE DETAILS
//    @ElementCollection
//    @Transient
    private String achievements;
    //ATHLETE DETAILS
    private Long position; //for player
    private Long clubId; //athlete's club
    //CLUB DETAILS
    private Long winnings; //todo: for club
    private Long losses;
    private String logoBase64;
    private String basicInfo;
//    private String players;
//    @OneToMany(mappedBy = "user")
//    private List<Long> results;
//    @Embedded
//    private ClubDetails clubDetails;
//    @Data
//    public static class ClubDetails{
//        private String logoBase64;
//        private String basicInfo;
//    }
}
