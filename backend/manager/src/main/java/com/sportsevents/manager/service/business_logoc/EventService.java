package com.sportsevents.manager.service.business_logoc;

import com.sportsevents.manager.DTO.RequestDTO.EventRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.GetAllEventsBySportClubAndIsFinished;
import com.sportsevents.manager.DTO.RequestDTO.GetEventDateBetweenAndEventTypeRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.GetEventDateBetweenRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.EventResponseDTO;

import java.util.List;

public interface EventService {

    EventResponseDTO createEvent(EventRequestDTO requestDTO);

    EventResponseDTO getById(Long id); //done

    List<EventResponseDTO> getALl(); //no need to implement

    List<EventResponseDTO> getAllByEventId(Long id); //done

    EventResponseDTO updateEvent(EventRequestDTO requestDTO, Long id);

    //todo: get by date
    List<EventResponseDTO> getByEventDateBetweenAndEventType(GetEventDateBetweenAndEventTypeRequestDTO requestDTO);
    List<EventResponseDTO> getByEventDateBetween(GetEventDateBetweenRequestDTO requestDTO); //no need to implement

    List<EventResponseDTO> getAllEventsByIsFinished(Boolean isFinished);

    List<EventResponseDTO> getAllEventsBySportClub(Long id);

    List<EventResponseDTO> getAllEventsBySportsClubAndIsFinished(GetAllEventsBySportClubAndIsFinished requestDTO);

}
