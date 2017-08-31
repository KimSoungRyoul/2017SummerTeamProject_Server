package org.arachne.application;

import java.util.Set;

import org.arachne.domain.account.MemberAccount;
import org.arachne.domain.account.Role;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface MemberAccountLoginService extends UserDetailsService {

	Set<Role> getAuthorities(String username);

	PasswordEncoder passwordEncoder();

	void registerMemberAccount(MemberAccount account);
	
	MemberAccount readUser(String username);

	void withdrawAccount(String username);

}
