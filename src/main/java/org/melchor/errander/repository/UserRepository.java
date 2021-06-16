package org.melchor.errander.repository;

import org.melchor.errander.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByEmail(String email);
}
