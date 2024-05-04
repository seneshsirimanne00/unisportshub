package com.sportsevents.manager.controller;

import com.sportsevents.manager.DTO.RequestDTO.GetTopPerformingRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.SportsClubRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.SportClubResponseDTO;
import com.sportsevents.manager.Helper.AccessManagements;
import com.sportsevents.manager.service.business_logoc.UserService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<SportClubResponseDTO> saveSportsClub(@RequestHeader(USER_ID) Long userId,
                                                               @RequestBody SportsClubRequestDTO requestDTO){
        if (AccessManagements.hasAccess(userId, ACCESS_LIST_ONLY_ADMIN)) {
            return new ResponseEntity<>(userService.saveSportsClub(requestDTO), HttpStatus.OK);
        }
        return null;
    }

    @PutMapping
    public ResponseEntity<SportClubResponseDTO> updateSportsCLub(@RequestHeader(USER_ID) Long userId,
                                                                 @RequestBody SportsClubRequestDTO requestDTO){
        if (AccessManagements.hasAccess(userId, ACCESS_LIST_ONLY_CLUB)) {
            return new ResponseEntity<>(userService.updateSportsClub(requestDTO, requestDTO.getId()), HttpStatus.OK);
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SportClubResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getSportClubById(id), HttpStatus.OK);
    }

    @GetMapping("/by-position")
    public ResponseEntity<List<SportClubResponseDTO>> getAllOrderByPosition(){
        return new ResponseEntity<>(userService.getAllPositionAscending(SPORTS_CLUB_CODE), HttpStatus.OK);
    }

    @PostMapping("top-performing")
    public ResponseEntity<List<SportClubResponseDTO>> getTopPerformingTeams(@RequestBody GetTopPerformingRequestDTO requestDTO){
        requestDTO.setUserId(SPORTS_CLUB_CODE);
        return new ResponseEntity<>(userService.getTopPerformingTeams(requestDTO), HttpStatus.OK);
    }

    /*
    * update events
    * create athletes
    * */
}
