package com.sportsevents.manager.controller;

import com.sportsevents.manager.DTO.RequestDTO.GetResultsBySportsClubAndSportRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.ResultRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.ResultResponseDTO;
import com.sportsevents.manager.Helper.AccessManagements;
import com.sportsevents.manager.service.business_logoc.ResultsService;

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
@RequestMapping("results")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResultsController {



    private final ResultsService resultsService;

//    @Autowired
//    public ResultsController(ResultsService resultsService) {
//        this.resultsService = resultsService;
//    }

    @PostMapping
    public ResponseEntity<ResultResponseDTO> createResult(@RequestHeader(USER_ID) Long userId,
                                                          @RequestBody ResultRequestDTO requestDTO){
        if (AccessManagements.hasAccess(userId, ACCESS_LIST_ONLY_ADMIN)) {
            return new ResponseEntity<>(resultsService.createResult(requestDTO), HttpStatus.OK);
        }
        return null;
    }

    @PutMapping
    public ResponseEntity<ResultResponseDTO> updateResult(@RequestHeader(USER_ID) Long userId,
                                                          @RequestBody ResultRequestDTO requestDTO){
        if (AccessManagements.hasAccess(userId, ACCESS_LIST_ONLY_ADMIN)) {
            return new ResponseEntity<>(resultsService.updateEvent(requestDTO, requestDTO.getId()), HttpStatus.OK);
        }
        return null;
    }

    //todo: need update

//    @GetMapping("get-by-sport-type/{id}")
//    public ResponseEntity<List<ResultResponseDTO>> get(@RequestHeader(USER_ID) String userId,
//                                                       @PathVariable(name = "id") Long sportTypeId ){
//        return new ResponseEntity<>(resultsService.getAllBySportType(sportTypeId), HttpStatus.OK);
//    }

    @GetMapping("get-all-by-club-and-sport")
    public ResponseEntity<List<ResultResponseDTO>> getAllBySportTeamId(@RequestHeader(USER_ID) String userId,
                                                                       @RequestBody GetResultsBySportsClubAndSportRequestDTO requestDTO){
        return new ResponseEntity<>(resultsService.getAllBySportClubAndType(requestDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(resultsService.getById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ResultResponseDTO>> getAll(){ //ordered by id
        return new ResponseEntity<>(resultsService.getAllBySportType(CRICKET), HttpStatus.OK);
    }














}
