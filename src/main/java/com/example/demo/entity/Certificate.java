package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "certificates", uniqueConstraints = {
        @UniqueConstraint(columnNames = "verificationCode")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private CertificateTemplate template;

    @Column(nullable = false, unique = true)
    private String verificationCode;

    @Column(length = 5000)
    private String qrCodeUrl;

    private LocalDateTime issuedAt;
}
