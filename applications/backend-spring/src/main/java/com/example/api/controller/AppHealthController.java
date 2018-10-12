package com.example.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitoring")
public class AppHealthController {

    @GetMapping("ready")
    public ResponseEntity isAppReady(){
        return ResponseEntity.ok(true);
    }


}
