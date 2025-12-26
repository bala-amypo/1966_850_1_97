package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    Optional<Certificate> findByVerificationCode(String verificationCode);
}
