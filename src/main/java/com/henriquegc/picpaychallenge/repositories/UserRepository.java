package com.henriquegc.picpaychallenge.repositories;

import com.henriquegc.picpaychallenge.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserById(String id);
}
