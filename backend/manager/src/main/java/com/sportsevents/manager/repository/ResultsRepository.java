package com.sportsevents.manager.repository;

import com.sportsevents.manager.Entity.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultsRepository extends JpaRepository<Results, Long>{

//    List<Results> findAllBySportTypeId(Long id);

//    List<Results> findAllByTeamAAndTeamBAndSportTypeId(User teamA, User TeamB, Long sportTypeId);
    List<Results> findAllByTeamAIdAndTeamBIdAndSportId(Long teamAId, Long teamBId, Long sportID);

    List<Results> findAllBySportIdOrderById(Long sportId);

    Optional<Results> findByEventId(Long eventId);

//    List<Results> findAllBy

//    List<Results> findAllByTeamAIdAndTeamBIdAndSportTypeId(Long TeamAId, Long id, )


}
