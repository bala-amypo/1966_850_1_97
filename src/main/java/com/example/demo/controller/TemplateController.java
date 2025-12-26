package com.example.demo.controller;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.TemplateService;

import java.util.List;

public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    public CertificateTemplate addTemplate(CertificateTemplate template) {
        return templateService.addTemplate(template);
    }

    public List<CertificateTemplate> getAllTemplates() {
        return templateService.getAllTemplates();
    }
}
