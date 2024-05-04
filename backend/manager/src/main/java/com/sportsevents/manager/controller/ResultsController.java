package com.sportsevents.manager.controller;

import com.sportsevents.manager.DTO.RequestDTO.GetResultsBySportsClubAndSportRequestDTO;
import com.sportsevents.manager.DTO.RequestDTO.ResultRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.ResultResponseDTO;
import com.sportsevents.manager.service.business_logoc.ResultsService;

import com.sportsevents.manager.service.business_logoc.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sportsevents.manager.Constants.Constants.CRICKET;
import static com.sportsevents.manager.Constants.Constants.USER_ID;

@RestController
@RequiredArgsConstructor
@RequestMapping("results")
public class ResultsController {



    private final ResultsService resultsService;

//    @Autowired
//    public ResultsController(ResultsService resultsService) {
//        this.resultsService = resultsService;
//    }

    @PostMapping("create")
    public ResponseEntity<ResultResponseDTO> createResult(@RequestHeader(USER_ID) String userId,
                                                          @RequestBody ResultRequestDTO requestDTO){
        //todo: need to add validation
        return new ResponseEntity<>(resultsService.createResult(requestDTO), HttpStatus.OK);
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
    public ResponseEntity<List<ResultResponseDTO>> getAll(){
        return new ResponseEntity<>(resultsService.getAllBySportType(CRICKET), HttpStatus.OK);
    }














}
