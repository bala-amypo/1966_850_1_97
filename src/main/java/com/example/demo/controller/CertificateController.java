package com.example.demo.controller;

import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    // method name "generate" required by tests
    @PostMapping("/generate/{studentId}/{templateId}")
    public Certificate generate(@PathVariable Long studentId,
                                @PathVariable Long templateId) {
        return certificateService.generateCertificate(studentId, templateId);
    }

    // method name "get" required by tests
    @GetMapping("/{certificateId}")
    public Certificate get(@PathVariable Long certificateId) {
        return certificateService.getCertificate(certificateId);
    }

    @GetMapping("/verify/code/{verificationCode}")
    public Certificate verifyByCode(@PathVariable String verificationCode) {
        return certificateService.findByVerificationCode(verificationCode);
    }
}
