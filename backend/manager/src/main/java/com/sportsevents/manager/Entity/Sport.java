package com.sportsevents.manager.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

//@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "sport")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Long ranking;
//    @OneToMany(mappedBy = "sportType")
//    private List<Long> events;
}
//todo: what is ranking?