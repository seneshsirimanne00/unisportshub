package com.sportsevents.manager.service.data_access.impl;

import com.sportsevents.manager.DTO.RequestDTO.*;
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
        event.setEligibilityDetails(convertToString(requestDTO.getEligibilityDetails()));
        event.setParticipationGuidelines(convertToString(requestDTO.getParticipationGuidelines()));
        event.setRegistrationProcedure(convertToString(requestDTO.getRegistrationProcedure()));
        event.setPlayers(convertLongToString(requestDTO.getPlayersIdList()));
        return eventRepository.save(event);
    }

    @Override
    public Event getById(Long id) {
        Optional<Event> event =  eventRepository.findById(id);
        return event.orElse(null);
    }

    @Override
    public List<Event> getALl() {
        return eventRepository.findByOrderByEventDateDesc();
    }

    @Override
    public List<Event> getByEventId(Long id) {
        return eventRepository.findAllByEventIdOrderByEventDateDesc(id);
    }

    @Override
    public List<Event> getAllByEventDate(GetAllEventsByDate requestDTO) {
        return eventRepository.findAllByEventDate(requestDTO.getEventDate());
    }


    @Override
    public Event updateEvent(EventRequestDTO requestDTO, Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()){
            EventMapper.INSTANCE.updateEventEntity(requestDTO, event.get());
            event.get().setEligibilityDetails(convertToString(requestDTO.getEligibilityDetails()));
            event.get().setParticipationGuidelines(convertToString(requestDTO.getParticipationGuidelines()));
            event.get().setRegistrationProcedure(convertToString(requestDTO.getRegistrationProcedure()));
            event.get().setPlayers(convertLongToString(requestDTO.getPlayersIdList()));
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
        return eventRepository.findAllByEventDateBetweenOrderByEventDateDesc(requestDTO.getStartDate(), requestDTO.getEndDate());
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

    private String convertToString(List<String> stringList){
        if (!(stringList == null || stringList.isEmpty())){
            return stringList.toString();
        }
        return null;
    }

    private String convertLongToString(List<Long> longList){
        if (!longList.isEmpty()){
            return longList.toString();
        }
        return null;
    }


}
