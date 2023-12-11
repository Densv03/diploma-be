package com.restfull.example.rest.repository;

import com.restfull.example.rest.entety.GroupNameEntity;
import com.restfull.example.rest.entety.ReceiverUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailRepository extends JpaRepository<ReceiverUserEntity, Integer> {

     void deleteByEmailAndAndGroupId(String email, Integer groupId);

     List<ReceiverUserEntity> findAllByGroupId(Integer groupId);
}
