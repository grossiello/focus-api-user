package com.example.demo.controller;

import com.example.demo.domain.dto.UserDTO;
import com.example.demo.domain.dto.UserLoginDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserDTO findOne(@PathVariable("id") int id) {
        return userService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> create(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return ResponseEntity.ok("UTENTE CREATO CORRETTAMENTE.");
    }

    @RequestMapping(path="/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody UserDTO userDTO) {
        userService.update(id, userDTO);
        return ResponseEntity.ok("UTENTE AGGIORNATO CORRETTAMENTE.");
    }

    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        userService.delete(id);
        return ResponseEntity.ok("UTENTE CANCELLATO CORRETTAMENTE.");
    }

    @RequestMapping(path="/login", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO userLoginDTO) {
        if (userService.login(userLoginDTO)) {
            return ResponseEntity.ok("LOGIN EFFETTUATO CON SUCCESSO.");
        } else {
            return ResponseEntity.ok("CREDENZIALI NON VALIDE.");
        }
    }
}
