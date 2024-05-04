package com.sportsevents.manager.controller;

import com.sportsevents.manager.DTO.RequestDTO.StudentRequestDTO;
import com.sportsevents.manager.DTO.ResponseDTO.StudentResponseDTO;
import com.sportsevents.manager.service.business_logoc.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sportsevents.manager.Constants.Constants.USER_ID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("student")
public class StudentController {

    private final UserService userService;

//    @Autowired
//    public StudentController(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> saveStudent(@RequestBody StudentRequestDTO requestDTO){
        return new ResponseEntity<>(userService.saveStudent(requestDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StudentResponseDTO> updateStudent(@RequestBody StudentRequestDTO requestDTO){
        return new ResponseEntity<>(userService.updateStudent(requestDTO, requestDTO.getId()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getStudentById(id), HttpStatus.OK);
    }
}
