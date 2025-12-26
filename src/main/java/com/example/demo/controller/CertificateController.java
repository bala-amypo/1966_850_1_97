package com.example.demo.controller;

import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;

import java.util.List;

public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    public Certificate generateCertificate(Long studentId, Long templateId) {
        return certificateService.generateCertificate(studentId, templateId);
    }

    public Certificate getCertificate(Long id) {
        return certificateService.getCertificate(id);
    }

    public List<Certificate> getCertificatesByStudent(Long studentId) {
        return certificateService.findByStudentId(studentId);
    }
}
