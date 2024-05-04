package com.sportsevents.manager.controller;

import com.sportsevents.manager.Constants.Constants;
import com.sportsevents.manager.DTO.RequestDTO.EventRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.GetAllEventsBySportClubAndIsFinished;
import com.sportsevents.manager.DTO.RequestDTO.GetEventDateBetweenAndEventTypeRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.EventResponseDTO;
import com.sportsevents.manager.service.business_logoc.EventService;
import com.sportsevents.manager.service.business_logoc.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sportsevents.manager.Constants.Constants.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("branch")
public class EventController {

    private final EventService eventService;

//    @Autowired
//    public EventController(EventService eventService) {
//        this.eventService = eventService;
//    }

    @PostMapping
    public ResponseEntity<EventResponseDTO> createEvent(@RequestHeader(USER_ID) Long userId,
                                                        @RequestBody EventRequestDTO requestDTO){
        //todo: validation
        return new ResponseEntity<>(eventService.createEvent(requestDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EventResponseDTO> updateEvent(@RequestHeader(USER_ID) Long userId,
                                                        @RequestBody EventRequestDTO requestDTO){
        //todo: validation
        return new ResponseEntity<>(eventService.updateEvent(requestDTO, requestDTO.getId()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(eventService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getAll(){
        return new ResponseEntity<>(eventService.getAllByEventId(CRICKET), HttpStatus.OK);
    }

    @PostMapping("/between-dates")
    public ResponseEntity<List<EventResponseDTO>> getAllBetweenDates(@RequestBody GetEventDateBetweenAndEventTypeRequestDTO requestDTO){
        return new ResponseEntity<>(eventService.getByEventDateBetweenAndEventType(requestDTO), HttpStatus.OK);
    }

    @PostMapping("/is-finished/{isFinished}")
    public ResponseEntity<List<EventResponseDTO>> getAllByFinished(@PathVariable Boolean isFinished){
        return new ResponseEntity<>(eventService.getAllEventsByIsFinished(isFinished), HttpStatus.OK);
    }

    @PostMapping("/by-sports-club/{id}")
    public ResponseEntity<List<EventResponseDTO>> getAllBySportsClub(@PathVariable Long id){
        return new ResponseEntity<>(eventService.getAllEventsBySportClub(id), HttpStatus.OK);
    }

    @PostMapping("/by-sports-club-and-is-finished")
    public ResponseEntity<List<EventResponseDTO>> getAllBySportsClubAndIsFinished(@RequestBody GetAllEventsBySportClubAndIsFinished requestDTO){
        return new ResponseEntity<>(eventService.getAllEventsBySportsClubAndIsFinished(requestDTO), HttpStatus.OK);
    }
}
