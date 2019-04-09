package com.trungpv.springrestapi.repository;

import com.trungpv.springrestapi.model.Role;
import com.trungpv.springrestapi.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 *
 * @author trungpv
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}
