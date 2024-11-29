package com.danilel.ecomerce.repository;

import com.danilel.ecomerce.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where  u.login = :login")
    Optional<User> findByLogin(String login);
    @Transactional
    @Modifying
    @Query("delete from User u where u.login = :login")
    void deleteByLogin(String login);
}
