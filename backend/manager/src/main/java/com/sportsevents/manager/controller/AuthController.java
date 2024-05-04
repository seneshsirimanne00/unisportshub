package com.sportsevents.manager.controller;

import com.sportsevents.manager.DTO.RequestDTO.LoginRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.SuccessResponseDTO;
import com.sportsevents.manager.service.business_logoc.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<SuccessResponseDTO> login(@RequestBody LoginRequestDTO requestDTO){
        return new ResponseEntity<>(userService.authenticateUser(requestDTO), HttpStatus.OK);
    }

}
