package com.sportsevents.manager.repository;

import com.sportsevents.manager.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUserId(Long id);

    User findByIdAndUserId(Long id, Long userId);

    List<User> findAllByUserIdAndPositionBetween(Long userId, Long startPosition, Long endPosition);
    List<User> findAllByUserIdAndWinningsBetween(Long userId, Long startPosition, Long endPosition);
    List<User> findAllByUserIdOrderByWinnings(Long userId);

    Optional<User> getByUsername(String username);

}
