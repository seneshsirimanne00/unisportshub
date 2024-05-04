package com.sportsevents.manager.service.data_access;

import com.sportsevents.manager.DTO.RequestDTO.EventRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.GetAllEventsBySportClubAndIsFinished;
import com.sportsevents.manager.DTO.RequestDTO.GetEventDateBetweenAndEventTypeRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.GetEventDateBetweenRequestDTO;
import com.sportsevents.manager.Entity.Event;

import java.util.List;

public interface EventDataService {

    Event createEvent(EventRequestDTO requestDTO);

    Event getById(Long id);

    List<Event> getALl();

    List<Event> getByEventId(Long id);

    Event updateEvent(EventRequestDTO requestDTO, Long id);

    List<Event> getByEventDateBetweenAndEventType(GetEventDateBetweenAndEventTypeRequestDTO requestDTO);
    List<Event> getByEventDateBetween(GetEventDateBetweenRequestDTO requestDTO);

    List<Event> getAllEventsByIsFinished(Boolean isFinished);

    List<Event> getAllEventsBySportClub(Long id);

    List<Event> getAllEventsBySportClubAndIsFinished(GetAllEventsBySportClubAndIsFinished requestDTO);

}
