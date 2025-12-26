package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    @PostMapping
    public String generateCertificate() {
        return "Certificate generated";
    }

    @GetMapping("/{id}")
    public String getCertificate(@PathVariable Long id) {
        return "Certificate details";
    }
}
