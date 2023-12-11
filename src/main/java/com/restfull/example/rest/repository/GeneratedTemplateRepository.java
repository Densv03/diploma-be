package com.restfull.example.rest.repository;

import com.restfull.example.rest.entety.GeneratedTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneratedTemplateRepository extends JpaRepository<GeneratedTemplateEntity, Integer> {

    List<GeneratedTemplateEntity> findAllById(Integer labelId);

}
