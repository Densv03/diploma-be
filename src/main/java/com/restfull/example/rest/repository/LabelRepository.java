package com.restfull.example.rest.repository;

import com.restfull.example.rest.entety.LabelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LabelRepository extends JpaRepository<LabelEntity, Integer> {


    List<LabelEntity> findAllByUserId(UUID userId);

    Optional<LabelEntity> findByUserIdAndName(UUID userId, String labelName);



}
