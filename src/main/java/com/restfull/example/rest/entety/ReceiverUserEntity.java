package com.restfull.example.rest.entety;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@Table(name = "receiver_user")
@NoArgsConstructor
public class ReceiverUserEntity {
    @Id
    private UUID sendingId;
    private String email;
}
