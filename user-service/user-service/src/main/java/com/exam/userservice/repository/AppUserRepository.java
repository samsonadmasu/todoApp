package com.exam.userservice.repository;

import com.exam.userservice.entity.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser,Integer> {
}
