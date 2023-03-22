package com.runtimeterror.onlinedeliveryportal.repo;

import com.runtimeterror.onlinedeliveryportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}

