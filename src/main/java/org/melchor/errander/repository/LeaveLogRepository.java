package org.melchor.errander.repository;

import org.melchor.errander.domain.LeaveLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveLogRepository extends JpaRepository<LeaveLog, Long> {
}
