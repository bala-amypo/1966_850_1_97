package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/templates")
public class TemplateController {

    @PostMapping
    public String createTemplate() {
        return "Template created";
    }

    @GetMapping("/{id}")
    public String getTemplate(@PathVariable Long id) {
        return "Template details";
    }
}
