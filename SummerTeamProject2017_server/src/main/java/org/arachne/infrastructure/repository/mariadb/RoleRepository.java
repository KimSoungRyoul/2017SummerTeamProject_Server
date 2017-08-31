package org.arachne.infrastructure.repository.mariadb;

import java.util.Set;

import org.arachne.domain.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{

	public Set<Role> findByAuthoritiesOwnerEmail(String email);
	
}
