package org.melchor.errander.repository;

import org.melchor.errander.domain.Chatting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChattingRepository extends JpaRepository<Chatting, Long> {

    Optional<Chatting> findByErrandId(Long errandId);
}
