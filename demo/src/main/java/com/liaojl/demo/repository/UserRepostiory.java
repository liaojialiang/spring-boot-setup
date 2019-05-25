package com.liaojl.demo.repository;

import com.liaojl.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liaojl
 */
public interface UserRepostiory extends JpaRepository<User, Long> {
}
