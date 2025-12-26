package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "certificates",
    uniqueConstraints = @UniqueConstraint(columnNames = "verificationCode")
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(optional = true)
    @JoinColumn(name = "template_id")
    private CertificateTemplate template;

    @Column(unique = true)
    private String verificationCode;

    private String qrCodeUrl;

    @Builder.Default
    private LocalDateTime issuedAt = LocalDateTime.now();
}
