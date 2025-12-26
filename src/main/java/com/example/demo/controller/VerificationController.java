package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    @GetMapping("/{certificateId}")
    public String verifyCertificate(@PathVariable Long certificateId) {
        return "Certificate verified";
    }
}
