package com.example.demo.service.impl;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.VerificationLog;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.service.VerificationService;

import java.time.LocalDateTime;
import java.util.List;

public class VerificationServiceImpl implements VerificationService {

    private final CertificateRepository certificateRepository;
    private final VerificationLogRepository logRepository;

    public VerificationServiceImpl(CertificateRepository certificateRepository,
                                   VerificationLogRepository logRepository) {
        this.certificateRepository = certificateRepository;
        this.logRepository = logRepository;
    }

    @Override
    public VerificationLog verifyCertificate(String verificationCode, String clientIp) {
        VerificationLog log = new VerificationLog();
        log.setVerifiedAt(LocalDateTime.now());
        log.setIpAddress(clientIp);

        certificateRepository.findByVerificationCode(verificationCode).ifPresentOrElse(cert -> {
            log.setCertificate(cert);
            log.setStatus("SUCCESS");
        }, () -> {
            log.setStatus("FAILED");
        });

        return logRepository.save(log);
    }

    @Override
    public List<VerificationLog> getLogsByCertificate(Long certificateId) {
        Certificate certificate = certificateRepository.findById(certificateId)
                .orElseThrow(() -> new RuntimeException("Certificate not found"));

        // simple approach: load all logs and filter in memory
        return logRepository.findAll().stream()
                .filter(l -> l.getCertificate() != null &&
                             certificateId.equals(l.getCertificate().getId()))
                .toList();
    }
}
