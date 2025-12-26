package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "verification_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String verificationCode;

    private String status;

    private String ipAddress;

    private LocalDateTime verifiedAt;
}
