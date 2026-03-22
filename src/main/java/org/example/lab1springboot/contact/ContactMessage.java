package org.example.lab1springboot.contact;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "contact_messages")
public class ContactMessage {
    @Id
    private Long id;

    private String firstName;
    private String email;

    private String phone;
    private String lastName;
    private String submit;

    @Column(columnDefinition = "TEXT")
    private String message;

    private LocalDateTime submittedAt = LocalDateTime.now();


}
