package com.runtimeterror.onlinedeliveryportal.repo;

import com.runtimeterror.onlinedeliveryportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM USER WHERE ID = ?1",nativeQuery = true)
    User getUserByUserID(String userId);

    @Query(value = "SELECT * FROM USER WHERE ID =?1 AND PASSWORD =?2",nativeQuery = true)
    User getUserByUserIDAndPassword(String userId,String address);

    User findByEmailAndUsername(String email, String username);
}
