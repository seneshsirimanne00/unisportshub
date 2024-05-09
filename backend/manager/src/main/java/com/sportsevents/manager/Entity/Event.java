package com.sportsevents.manager.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "event")
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@NoArgsConstructor
public class Event{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long eventId; //eventType
    private String name;
    private String description;
    private String eligibilityDetails;
    private String participationGuidelines;
    private String registrationProcedure;
    private LocalDateTime eventDate; //todo: events by dates
    private Long teamA; //todo: events team participating (past, present, future)
    private Long teamB;
    private Long sportId; //todo: get by sport id
    private Boolean isFinished; //todo: get by is finished || finish and event (also need to create result for event)
    private String players;
    private Long clubId;
    //todo: pre event post event
}
