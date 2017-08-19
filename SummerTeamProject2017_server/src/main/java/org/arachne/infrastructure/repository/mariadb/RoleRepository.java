package org.arachne.infrastructure.repository.mariadb;

import java.util.List;

import org.arachne.domain.account.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String>{

	public List<Role> findByAuthAccountEmail(String email);
	
}
