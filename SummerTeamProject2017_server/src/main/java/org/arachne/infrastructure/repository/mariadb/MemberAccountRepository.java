package org.arachne.infrastructure.repository.mariadb;

import javax.persistence.PersistenceException;

import org.arachne.domain.account.MemberAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAccountRepository extends JpaRepository<MemberAccount, Long>{
	
	public MemberAccount findByEmail(String email)throws PersistenceException;
	
	

}
