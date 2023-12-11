package com.restfull.example.rest.entety;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Table(name = "groups")
@NoArgsConstructor

public class GroupNameEntity {
 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 private Integer id;
 @Column(name = "user_id")
 private UUID userId;
 @Column(name = "group_name")
 private String groupName;

}

