package com.sportsevents.manager.service.data_access.impl;

import com.sportsevents.manager.DTO.RequestDTO.EventRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.GetAllEventsBySportClubAndIsFinished;
import com.sportsevents.manager.DTO.RequestDTO.GetEventDateBetweenAndEventTypeRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.GetEventDateBetweenRequestDTO;
import com.sportsevents.manager.Entity.Event;
import com.sportsevents.manager.Mapper.EventMapper;
import com.sportsevents.manager.repository.EventRepository;
import com.sportsevents.manager.service.data_access.EventDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventDataServiceImpl implements EventDataService{

    private final EventRepository eventRepository;

    @Override
    public Event createEvent(EventRequestDTO requestDTO) {
        Event event = EventMapper.INSTANCE.eventRequestDtoToEntity(requestDTO);
        event.setEligibilityDetails(requestDTO.getEligibilityDetails().toString());
        event.setParticipationGuidelines(requestDTO.getParticipationGuidelines().toString());
        event.setRegistrationProcedure(requestDTO.getRegistrationProcedure().toString());
        event.setPlayers(requestDTO.getPlayersIdList().toString());
        return eventRepository.save(event);
    }

    @Override
    public Event getById(Long id) {
        Optional<Event> event =  eventRepository.findById(id);
        return event.orElse(null);
    }

    @Override
    public List<Event> getALl() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getByEventId(Long id) {
        return eventRepository.findAllByEventIdOrderByEventDate(id);
    }

    @Override
    public Event updateEvent(EventRequestDTO requestDTO, Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()){
            EventMapper.INSTANCE.updateEventEntity(requestDTO, event.get());
            event.get().setPlayers(requestDTO.getPlayersIdList().toString());
            return eventRepository.save(event.get());
        }else {
            return null;
        }
    }

    @Override
    public List<Event> getByEventDateBetweenAndEventType(GetEventDateBetweenAndEventTypeRequestDTO requestDTO) {
        return eventRepository.findAllByEventDateBetweenAndEventId(requestDTO.getStartDate(), requestDTO.getEndDate(), requestDTO.getEventId());
    }

    @Override
    public List<Event> getByEventDateBetween(GetEventDateBetweenRequestDTO requestDTO) {
        return eventRepository.findAllByEventDateBetweenOrderByEventDate(requestDTO.getStartDate(), requestDTO.getEndDate());
    }

    @Override
    public List<Event> getAllEventsByIsFinished(Boolean isFinished) {
        return eventRepository.findAllByIsFinished(isFinished);
    }

    @Override
    public List<Event> getAllEventsBySportClub(Long id) {
//        return eventRepository.findAllByTeamAAndTeamB(id, id);
        return null;
    }

    @Override
    public List<Event> getAllEventsBySportClubAndIsFinished(GetAllEventsBySportClubAndIsFinished requestDTO) {
//        List<Event> eventsTeamA = eventRepository.findAllByTeamAAndIsFinished(requestDTO.getSportLClubId(), requestDTO.getIsFinished());
//        List<Event> eventsTeamB = eventRepository.findAllByTeamBAndIsFinished(requestDTO.getSportLClubId(), requestDTO.getIsFinished());
//        return eventsTeamA;
        return eventRepository.findAllByTeamAAndTeamBAndIsFinished(requestDTO.getSportLClubId(), requestDTO.getSportLClubId(), requestDTO.getIsFinished());
    }


}
