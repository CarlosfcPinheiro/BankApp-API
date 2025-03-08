package me.dio.api_rest_springboot.domain.repository;

import me.dio.api_rest_springboot.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
