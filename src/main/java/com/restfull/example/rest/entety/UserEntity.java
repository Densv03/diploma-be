package com.restfull.example.rest.entety;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, name = "user_id")
    private UUID userId;
    @Column
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column
    private String password;
    @Column(nullable = false, name = "encrypted_password")
    private String encryptedPassword;
    @Column(name = "email_verification_token")
    private String emailVerificationToken;
    @Column(name = "email_verification_status")
    private Boolean emailVerificationStatus = false;
}
