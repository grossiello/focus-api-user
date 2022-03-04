package com.example.demo.controller;

import com.example.demo.domain.dto.UserDTO;
import com.example.demo.domain.dto.UserLoginDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class HealthController {

    @RequestMapping(path="/ready", method = RequestMethod.GET)
    public ResponseEntity<Void> isReady() {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(path="/health", method = RequestMethod.GET)
    public ResponseEntity<Void> isHealthy() {
        return ResponseEntity.ok(null);
    }
}