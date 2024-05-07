package com.sportsevents.manager.controller;

import com.sportsevents.manager.Constants.Constants;
import com.sportsevents.manager.DTO.RequestDTO.EventRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.GetAllEventsByDate;
import com.sportsevents.manager.DTO.RequestDTO.GetAllEventsBySportClubAndIsFinished;
import com.sportsevents.manager.DTO.RequestDTO.GetEventDateBetweenAndEventTypeRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.EventResponseDTO;
import com.sportsevents.manager.Helper.AccessManagements;
import com.sportsevents.manager.service.business_logoc.EventService;
import com.sportsevents.manager.service.business_logoc.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Helper;
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
@RequestMapping("event")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventController {

    private final EventService eventService;

//    @Autowired
//    public EventController(EventService eventService) {
//        this.eventService = eventService;
//    }

    @PostMapping
    public ResponseEntity<EventResponseDTO> createEvent(@RequestHeader(USER_ID) Long userId,
                                                        @RequestBody EventRequestDTO requestDTO){
        if (AccessManagements.hasAccess(userId, ACCESS_LIST_ONLY_ADMIN)){
            return new ResponseEntity<>(eventService.createEvent(requestDTO), HttpStatus.OK);
        }
        return null;

    }

    @PutMapping
    public ResponseEntity<EventResponseDTO> updateEvent(@RequestHeader(USER_ID) Long userId,
                                                        @RequestBody EventRequestDTO requestDTO){
        if (AccessManagements.hasAccess(userId, ACCESS_LIST_ADMIN_CLUB)) {
            return new ResponseEntity<>(eventService.updateEvent(requestDTO, requestDTO.getId()), HttpStatus.OK);
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(eventService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getAll(){ //get all events ordered by event date
        return new ResponseEntity<>(eventService.getALl(), HttpStatus.OK);
    }

    @GetMapping("friendly-matches")
    public ResponseEntity<List<EventResponseDTO>> getAllFriendlyMatches(){ //get all events ordered by event date
        return new ResponseEntity<>(eventService.getAllByEventId(FRIENDLY_MATCH), HttpStatus.OK);
    }

    @GetMapping("tournament/")
    public ResponseEntity<List<EventResponseDTO>> getAllTournaments(){ //get all events ordered by event date
        return new ResponseEntity<>(eventService.getAllByEventId(TOURNAMENT), HttpStatus.OK);
    }

    @PostMapping("/between-dates")
    public ResponseEntity<List<EventResponseDTO>> getAllBetweenDates(@RequestBody GetEventDateBetweenAndEventTypeRequestDTO requestDTO){
        return new ResponseEntity<>(eventService.getByEventDateBetweenAndEventType(requestDTO), HttpStatus.OK);
    }

    @PostMapping("/by-date")
    public ResponseEntity<List<EventResponseDTO>> getAllByDates(@RequestBody GetAllEventsByDate requestDTO){
        return new ResponseEntity<>(eventService.getAllByEventDate(requestDTO), HttpStatus.OK);
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
