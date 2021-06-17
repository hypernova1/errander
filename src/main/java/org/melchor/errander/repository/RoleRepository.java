package org.melchor.errander.repository;

import org.melchor.errander.constant.RoleName;
import org.melchor.errander.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName name);

}
