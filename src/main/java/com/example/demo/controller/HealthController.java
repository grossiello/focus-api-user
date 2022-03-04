package com.example.demo.controller;

import com.example.demo.domain.dto.UserDTO;
import com.example.demo.domain.dto.UserLoginDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class HealthController {

    @RequestMapping(path="/ready", method = RequestMethod.GET)
    public ResponseEntity<void> isReady() {
        return ResponseEntity.ok(void);
    }

    @RequestMapping(path="/health", method = RequestMethod.GET)
    public List<UserDTO> findAll() {
        return ResponseEntity.ok(void);
    }
}