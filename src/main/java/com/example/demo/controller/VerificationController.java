package com.example.demo.controller;

import com.example.demo.entity.Certificate;
import com.example.demo.service.VerificationService;

public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    public Certificate verify(String verificationCode, String ipAddress) {
        return verificationService.verify(verificationCode, ipAddress);
    }
}
