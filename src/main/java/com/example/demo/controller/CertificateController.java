package com.example.demo.controller;

import com.example.demo.entity.DigitalCertificate;
import com.example.demo.service.DigitalCertificateService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final DigitalCertificateService certificateService;

    public CertificateController(DigitalCertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @PostMapping
    public ResponseEntity<DigitalCertificate> create(
            @RequestBody DigitalCertificate certificate) {

        DigitalCertificate saved = certificateService.createCertificate(certificate);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DigitalCertificate> getById(@PathVariable Long id) {
        return ResponseEntity.ok(certificateService.getCertificateById(id));
    }

    @GetMapping
    public ResponseEntity<List<DigitalCertificate>> getAll() {
        return ResponseEntity.ok(certificateService.getAllCertificates());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
        return ResponseEntity.ok("Certificate deleted successfully");
    }
}
