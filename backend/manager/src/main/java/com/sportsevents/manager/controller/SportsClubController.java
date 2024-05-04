package com.sportsevents.manager.controller;

import com.sportsevents.manager.DTO.RequestDTO.SportsClubRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.SportClubResponseDTO;
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
@RequestMapping("sports-club")
public class SportsClubController {

    private final UserService userService;

//    @Autowired
//    public SportsClubController(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping
    public ResponseEntity<SportClubResponseDTO> saveSportsClub(@RequestBody SportsClubRequestDTO requestDTO){
        return new ResponseEntity<>(userService.saveSportsClub(requestDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SportClubResponseDTO> updateSportsCLub(@RequestBody SportsClubRequestDTO requestDTO){
        return new ResponseEntity<>(userService.updateSportsClub(requestDTO, requestDTO.getId()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SportClubResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getSportClubById(id), HttpStatus.OK);
    }

    @GetMapping("/by-position")
    public ResponseEntity<List<SportClubResponseDTO>> getAllOrderByPosition(){
        return new ResponseEntity<>(userService.getAllPositionAscending(SPORTS_CLUB_CODE), HttpStatus.OK);
    }
}
