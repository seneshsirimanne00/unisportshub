package com.sportsevents.manager.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

//@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "results")
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Builder
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long teamAScore;
    private Long teamBScore;
    private String teamAName;
    private String teamBName;
//    @ManyToOne
//    @JoinColumn(name = "team_a_id")
    private Long teamAId;
//    @ManyToOne
//    @JoinColumn(name = "team_b_id")
    private Long teamBId; //todo: get by team Id;
//    @ElementCollection
//    @Transient
    private String achievements;
//    @ManyToOne
//    @JoinColumn(name = "sport_id")
    private Long sportId; //todo: get all by sport id;
//    @ManyToOne
//    @JoinColumn(name = "event_id")
    private Long eventId; //todo: find by sport event Id

}
