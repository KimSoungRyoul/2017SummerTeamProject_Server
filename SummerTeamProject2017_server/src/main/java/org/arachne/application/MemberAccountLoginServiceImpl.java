package org.arachne.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.arachne.domain.account.AuthorityType;
import org.arachne.domain.account.MemberAccount;
import org.arachne.domain.account.Role;
import org.arachne.infrastructure.repository.mariadb.MemberAccountRepository;
import org.arachne.infrastructure.repository.mariadb.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberAccountLoginServiceImpl implements MemberAccountLoginService {

	@Autowired
	private MemberAccountRepository mAccountRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


	@PostConstruct
	@Transactional
	public void initAccount(){
		
		MemberAccount memberAccount=new MemberAccount("sky5367@naver.com",passwordEncoder.encode("1234"),"010-7237-6602");
		
		Role role=new Role();
		role.setAuthAccount(memberAccount);
		role.setAuthorityType(AuthorityType.NORMAL_USER);
		
		List<Role> roles=new ArrayList<>();
		roles.add(role);
		
		
		memberAccount.setAuthorities(roles);
		
		
		
		mAccountRepository.save(memberAccount);
		roleRepository.save(role);
		
		
	}
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		MemberAccount mAccount = mAccountRepository.findByEmail(email);
		
	//	log.info("------------"+mAccount.toString());
		
		
		mAccount.setAuthorities(getAuthorities(email));
		
		
		//log.info("-----권한 추가된 계정정보-----"+mAccount.toString());
		
		return mAccount;
	}

	@Override
	public List<Role> getAuthorities(String username) {
		
		List<Role> string_authorities = roleRepository.findByAuthAccountEmail(username);
		
		/*List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role authority : string_authorities) {
			authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
		}*/
		return string_authorities;
	}

	@Override
	public PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return this.passwordEncoder;
	}

	@Override
	public MemberAccount readUser(String email) {
		// TODO Auto-generated method stub
		MemberAccount mAccount = mAccountRepository.findByEmail(email);

		return mAccount;
	}

	@Override
	public void registerMemberAccount(MemberAccount account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawAccount(String username) {
		// TODO Auto-generated method stub
		
	}

}
