package com.example.demo.service.impl;

import com.example.demo.entity.VerificationLog;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.service.VerificationService;
import org.springframework.stereotype.Service;

@Service
public class VerificationServiceImpl implements VerificationService {

    private final VerificationLogRepository repository;

    public VerificationServiceImpl(VerificationLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public VerificationLog save(VerificationLog log) {
        return repository.save(log);
    }
}
