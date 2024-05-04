package com.sportsevents.manager.service.business_logoc.impl;

import com.sportsevents.manager.DTO.RequestDTO.*;
import com.sportsevents.manager.DTO.ResponseDTO.EventResponseDTO;
import com.sportsevents.manager.Entity.Event;
import com.sportsevents.manager.Mapper.EventMapper;
import com.sportsevents.manager.service.business_logoc.EventService;
import com.sportsevents.manager.service.data_access.EventDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventServiceImpl implements EventService {

    private final EventDataService eventDataService;

    @Override
    public EventResponseDTO createEvent(EventRequestDTO requestDTO) {
        Event event = eventDataService.createEvent(requestDTO);
        EventResponseDTO eventResponseDTO =  EventMapper.INSTANCE.eventToEventResponseDTO(event);
        eventToResponseDTO(event, eventResponseDTO);
        return eventResponseDTO;
    }

    @Override
    public EventResponseDTO getById(Long id) {
        Event event = eventDataService.getById(id);
        EventResponseDTO eventResponseDTO = EventMapper.INSTANCE.eventToEventResponseDTO(event);
        eventToResponseDTO(event, eventResponseDTO);
        return eventResponseDTO;
    }

    @Override
    public List<EventResponseDTO> getALl() {
        List<Event> events = eventDataService.getALl();
        if (!events.isEmpty()){
            List<EventResponseDTO> eventResponseDTOS = events.stream().map(EventMapper.INSTANCE::eventToEventResponseDTO).toList();
            eventListToResponseDTOList(events, eventResponseDTOS);
            return eventResponseDTOS;
        }
        return null;
    }

    @Override
    public List<EventResponseDTO> getAllByEventDate(GetAllEventsByDate requestDTO) {
        List<Event> events = eventDataService.getAllByEventDate(requestDTO);
        if (!events.isEmpty()){
            List<EventResponseDTO> eventResponseDTOS = events.stream().map(EventMapper.INSTANCE::eventToEventResponseDTO).toList();
            eventListToResponseDTOList(events, eventResponseDTOS);
            return eventResponseDTOS;
        }
        return null;
    }


    @Override
    public List<EventResponseDTO> getAllByEventId(Long id) {
        List<Event> events = eventDataService.getByEventId(id);
        if (!events.isEmpty()){
            List<EventResponseDTO> eventResponseDTOS = events.stream().map(EventMapper.INSTANCE::eventToEventResponseDTO).toList();
            eventListToResponseDTOList(events, eventResponseDTOS);
            return eventResponseDTOS;
        }
        return null;
    }

    @Override
    public EventResponseDTO updateEvent(EventRequestDTO requestDTO, Long id) {
        Event event = eventDataService.updateEvent(requestDTO, id);
        EventResponseDTO eventResponseDTO =  EventMapper.INSTANCE.eventToEventResponseDTO(event);
        eventToResponseDTO(event, eventResponseDTO);
        return eventResponseDTO;
    }

    @Override
    public List<EventResponseDTO> getByEventDateBetweenAndEventType(GetEventDateBetweenAndEventTypeRequestDTO requestDTO) {
        List<Event> events = eventDataService.getByEventDateBetweenAndEventType(requestDTO);
        if (!events.isEmpty()){
            List<EventResponseDTO> eventResponseDTOS = events.stream().map(EventMapper.INSTANCE::eventToEventResponseDTO).toList();
            eventListToResponseDTOList(events, eventResponseDTOS);
            return eventResponseDTOS;
        }
        return null;
    }

    @Override
    public List<EventResponseDTO> getByEventDateBetween(GetEventDateBetweenRequestDTO requestDTO) {
        List<Event> events = eventDataService.getByEventDateBetween(requestDTO);
        if (!events.isEmpty()){
            List<EventResponseDTO> eventResponseDTOS = events.stream().map(EventMapper.INSTANCE::eventToEventResponseDTO).toList();
            eventListToResponseDTOList(events, eventResponseDTOS);
            return eventResponseDTOS;
        }
        return null;
    }

    @Override
    public List<EventResponseDTO> getAllEventsByIsFinished(Boolean isFinished) {
        List<Event> events = eventDataService.getAllEventsByIsFinished(isFinished);
        if (!events.isEmpty()){
            List<EventResponseDTO> eventResponseDTOS = events.stream().map(EventMapper.INSTANCE::eventToEventResponseDTO).toList();
            eventListToResponseDTOList(events, eventResponseDTOS);
            return eventResponseDTOS;
        }
        return null;
    }

    @Override
    public List<EventResponseDTO> getAllEventsBySportClub(Long id) {
        List<Event> events = eventDataService.getAllEventsBySportClub(id);
        if (!events.isEmpty()){
            List<EventResponseDTO> eventResponseDTOS = events.stream().map(EventMapper.INSTANCE::eventToEventResponseDTO).toList();
            eventListToResponseDTOList(events, eventResponseDTOS);
            return eventResponseDTOS;
        }
        return null;
    }

    @Override
    public List<EventResponseDTO> getAllEventsBySportsClubAndIsFinished(GetAllEventsBySportClubAndIsFinished requestDTO) {
        List<Event> events = eventDataService.getAllEventsBySportClubAndIsFinished(requestDTO);
        if (!events.isEmpty()){
            List<EventResponseDTO> eventResponseDTOS = events.stream().map(EventMapper.INSTANCE::eventToEventResponseDTO).toList();
            eventListToResponseDTOList(events, eventResponseDTOS);
            return eventResponseDTOS;
        }
        return null;
    }

    public List<String> stringToList(String strList){
        if (!StringUtils.isBlank(strList)){
            return Arrays.asList(strList.split(","));
        }
        return null;
    }

    public List<Long> stringToLong(String strList){
        if (!StringUtils.isBlank(strList)){
            return Arrays.stream(strList.split(","))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public void eventToResponseDTO(Event event, EventResponseDTO eventResponseDTO){
        eventResponseDTO.setEligibilityDetails(this.stringToList(event.getEligibilityDetails()));
        eventResponseDTO.setParticipationGuidelines(this.stringToList(event.getParticipationGuidelines()));
        eventResponseDTO.setRegistrationProcedure(this.stringToList(event.getRegistrationProcedure()));
        eventResponseDTO.setPlayersIdList(this.stringToLong(event.getPlayers()));
    }

    public void eventListToResponseDTOList(List<Event> events, List<EventResponseDTO> eventResponseDTOS){
        for (int i = 0; i < events.size(); i++){
            eventToResponseDTO(events.get(i), eventResponseDTOS.get(i));
        }
    }


}
