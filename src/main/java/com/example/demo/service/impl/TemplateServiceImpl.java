package com.example.demo.service.impl;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.repository.CertificateTemplateRepository;
import com.example.demo.service.TemplateService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TemplateServiceImpl implements TemplateService {

    private final CertificateTemplateRepository templateRepository;

    public TemplateServiceImpl(CertificateTemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    @Override
    public CertificateTemplate addTemplate(CertificateTemplate template) {
        // duplicate name check
        if (templateRepository.findByTemplateName(template.getTemplateName()).isPresent()) {
            throw new RuntimeException("Template name exists");
        }

        // simple URL validation (non‑blank and syntactically valid)
        String bg = template.getBackgroundUrl();
        if (bg == null || bg.isBlank()) {
            throw new RuntimeException("Invalid backgroundUrl");
        }
        try {
            new URL(bg);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid backgroundUrl");
        }

        return templateRepository.save(template);
    }

    @Override
    public List<CertificateTemplate> getAllTemplates() {
        return templateRepository.findAll();
    }

    @Override
    public CertificateTemplate findById(Long id) {
        return templateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found"));
    }
}
