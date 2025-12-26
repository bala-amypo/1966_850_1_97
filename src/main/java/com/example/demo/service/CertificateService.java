package com.example.demo.service;

import com.example.demo.entity.Certificate;

import java.util.Optional;

public interface CertificateService {

    Optional<Certificate> getCertificateByVerificationCode(String verificationCode);
}
