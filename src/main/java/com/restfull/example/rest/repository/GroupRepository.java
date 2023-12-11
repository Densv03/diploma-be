package com.restfull.example.rest.repository;

import com.restfull.example.rest.entety.GroupNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<GroupNameEntity, Integer> {

    Optional<GroupNameEntity> findByGroupNameAndUserId(String groupName, UUID userId);

    List<GroupNameEntity> findAllByUserId(UUID userId);
}
