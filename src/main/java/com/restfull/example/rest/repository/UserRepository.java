package com.restfull.example.rest.repository;

import com.restfull.example.rest.entety.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);

    UserEntity findByUserId(String uuid);

}
