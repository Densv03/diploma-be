package com.restfull.example.rest.repository;

import com.restfull.example.rest.entety.PushEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PushRepository extends JpaRepository<PushEntity, Integer> {

}
