package com.restfull.example.rest.repository;

import com.restfull.example.rest.entety.PushEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PushRepository extends JpaRepository<PushEntity, Integer> {

    List<PushEntity> findByIsSendIsFalse();

}
