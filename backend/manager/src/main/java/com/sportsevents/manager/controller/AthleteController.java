package com.sportsevents.manager.controller;

import com.sportsevents.manager.DTO.RequestDTO.AthleteRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.GetTopPerformingRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.SportsClubRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.AthleteResponseDTO;
import com.sportsevents.manager.DTO.ResponseDTO.SportClubResponseDTO;
import com.sportsevents.manager.Helper.AccessManagements;
import com.sportsevents.manager.service.business_logoc.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sportsevents.manager.Constants.Constants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("athlete")
public class AthleteController {

    private final UserService userService;

//    @Autowired
//    public AthleteController(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping
    public ResponseEntity<AthleteResponseDTO> saveAthlete(@RequestHeader(USER_ID) Long userId,
                                                          @RequestBody AthleteRequestDTO requestDTO){
        if (AccessManagements.hasAccess(userId, ACCESS_LIST_ONLY_CLUB)) {
            return new ResponseEntity<>(userService.saveAthlete(requestDTO), HttpStatus.OK);
        }
        return null;
    }

    @PutMapping
    public ResponseEntity<AthleteResponseDTO> updateAthlete(@RequestBody AthleteRequestDTO requestDTO){
        return new ResponseEntity<>(userService.updateAthlete(requestDTO, requestDTO.getId()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AthleteResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getAthleteById(id), HttpStatus.OK);
    }

    @GetMapping("/by-position")
    public ResponseEntity<List<SportClubResponseDTO>> getAllOrderByPosition(){
        return new ResponseEntity<>(userService.getAllPositionAscending(ATHLETE_CODE), HttpStatus.OK);
    }

    @PostMapping("top-performing")
    public ResponseEntity<List<AthleteResponseDTO>> getTopPerformingTeams(@RequestBody GetTopPerformingRequestDTO requestDTO){
        requestDTO.setUserId(ATHLETE_CODE);
        return new ResponseEntity<>(userService.getTopPerformingAthletes(requestDTO), HttpStatus.OK);
    }
}
