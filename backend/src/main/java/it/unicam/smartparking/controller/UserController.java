package it.unicam.smartparking.controller;


import it.unicam.smartparking.dto.UsersDto;
import it.unicam.smartparking.service.RolesService;
import it.unicam.smartparking.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RolesService rolesService;

    @GetMapping(value = "/test")
    public ResponseEntity<?> test(){


        return ResponseEntity.ok("Test");
    }


    @GetMapping(value = "/users")
    public ResponseEntity<?> getUsers(){

        List<UsersDto> users = usersService.getAllUsers();

        return ResponseEntity.ok(users);
    }


}
