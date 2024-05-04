package com.sportsevents.manager.repository;

import com.sportsevents.manager.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

    Optional<Event> findById(long id);

//    List<Event> findAll();
    List<Event> findByOrderByEventDateDesc();

    List<Event> findAllByEventIdOrderByEventDateDesc(long id);

    List<Event> findAllByEventDate(LocalDateTime eventDate);

    List<Event> findAllByEventDateBetweenAndEventId(LocalDateTime startDate, LocalDateTime endDate, Long eventId);

    List<Event> findAllByEventDateBetweenOrderByEventDateDesc(LocalDateTime startDate, LocalDateTime endDate);

    List<Event> findAllByIsFinished(Boolean isFinished);

    List<Event> findAllBySportId(Long sportId);

//    List<Event> findAllByTeamAAndTeamB(Long teamAId, Long teamBId);

    List<Event> findAllByTeamAAndTeamBAndIsFinished(Long teamAId, Long teamBId, Boolean isFinished);

//    List<Event> findAllByTeamAAndIsFinished(Long teamA, Boolean isFinished);
//    List<Event> findAllByTeamBAndIsFinished(Long teamB, Boolean isFinished);

//    List<Event> findAllByTeamAOrTeam




}
