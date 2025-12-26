package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "certificates", uniqueConstraints = {
        @UniqueConstraint(columnNames = "verificationCode")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many certificates -> one student
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Many certificates -> one template
    @ManyToOne
    @JoinColumn(name = "template_id")
    private CertificateTemplate template;

    private LocalDate issuedDate;

    // data:image/png;base64,...
    @Column(length = 4000)
    private String qrCodeUrl;

    // must start with "VC-"; uniqueness enforced at table level
    @Column(nullable = false, unique = true)
    private String verificationCode;

    @OneToMany(mappedBy = "certificate")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<VerificationLog> verificationLogs;
}
