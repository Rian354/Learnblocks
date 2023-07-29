package com.rian.learnblock.repository;

import com.rian.learnblock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Object> {

    @Query(value = "SELECT * FROM USER u WHERE u.username = :id limit 1", nativeQuery = true)
    User getUserByUsername(String id);


    @Query(
            value = "SELECT * FROM USER u WHERE u.email = :email limit 1",
            nativeQuery = true)
    User getUserByEmail(String email);

    @Query(
            value = "SELECT * FROM USER u WHERE u.email = :email and u.password = :password",
            nativeQuery = true)
    List<User> getUserByUserAndEmail(String email, String password);
}