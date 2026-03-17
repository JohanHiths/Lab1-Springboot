package org.example.lab1springboot.contact;


import jakarta.validation.constraints.NotBlank;

public record ContactForm(
        @NotBlank(message = "First name is required")
        String firstName,
        @NotBlank(message = "Last name is required")
        String lastName,
        @NotBlank(message = "Email is required")
        String email,
        @NotBlank(message = "Phone number is required")
        String phone,
        @NotBlank(message = "Message is required")
        String message
) {}
