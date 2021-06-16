package org.melchor.errander.repository;

import org.melchor.errander.domain.Errand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrandRepository extends JpaRepository<Errand, Long> {
}
