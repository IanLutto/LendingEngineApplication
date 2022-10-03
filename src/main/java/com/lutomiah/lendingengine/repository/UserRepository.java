package com.lutomiah.lendingengine.repository;

import com.lutomiah.lendingengine.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
