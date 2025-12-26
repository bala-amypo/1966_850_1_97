package com.example.demo.controller;

import com.example.demo.entity.VerificationLog;
import com.example.demo.service.VerificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    // method name "verify" not used by tests, but endpoint is required
    @PostMapping("/{verificationCode}")
    public VerificationLog verify(@PathVariable String verificationCode,
                                  HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        return verificationService.verifyCertificate(verificationCode, ip);
    }

    // method name "logs" not used by tests, but endpoint is required
    @GetMapping("/logs/{certificateId}")
    public List<VerificationLog> logs(@PathVariable Long certificateId) {
        return verificationService.getLogsByCertificate(certificateId);
    }
}
