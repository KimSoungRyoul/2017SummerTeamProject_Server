package org.arachne.application.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.arachne.application.MemberAccountLoginService;
import org.arachne.domain.account.MemberAccount;
import org.arachne.domain.account.Role;
import org.arachne.domain.account.RoleType;
import org.arachne.infrastructure.repository.mariadb.MemberAccountRepository;
import org.arachne.infrastructure.repository.mariadb.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberAccountLoginServiceImpl implements MemberAccountLoginService {

	@Autowired
	private MemberAccountRepository mAccountRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	@Transactional
	public void initAccount() {

		log.info("테스트 계정 하나 생성함 ...................");

		MemberAccount memberAccount = new MemberAccount("sky5367@naver.com", passwordEncoder.encode("1234"),
				"010-7237-6602", "김성렬");

		Role role = new Role();
		role.setAuthority(RoleType.ROLE_NORMAL_USER);
		role.setAuthoritiesOwner(memberAccount);

		Set<Role> roles = new HashSet<>();
		roles.add(role);

		role.setAuthoritiesOwner(memberAccount);
		memberAccount.setAuthorities(roles);

		registerMemberAccount(memberAccount);

	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		MemberAccount mAccount = mAccountRepository.findOneByEmail(email);

		if (mAccount == null) {
			throw new UsernameNotFoundException("회원정보가  없어요  로그인 불가해여..........");
		}

		log.info("호오 ? 로그인에 성공하셨어요  ...........");
		return mAccount;
	}

	@Override
	public Set<Role> getAuthorities(String username) {

		Set<Role> string_authorities = roleRepository.findByAuthoritiesOwnerEmail(username);

		/*
		 * List<GrantedAuthority> authorities = new
		 * ArrayList<GrantedAuthority>(); for (Role authority :
		 * string_authorities) { authorities.add(new
		 * SimpleGrantedAuthority(authority.getAuthority())); }
		 */
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
		MemberAccount mAccount = mAccountRepository.findOneByEmail(email);
		
		if (mAccount == null) {
			throw new UsernameNotFoundException("존재하지 않는 회원입니다..........");
		}
		
		mAccount.deleteSecurityInfo();
		return mAccount;
	}

	@Override
	@Transactional
	public void registerMemberAccount(MemberAccount account) {
		// TODO Auto-generated method stub

		mAccountRepository.save(account);
		roleRepository.save(account.getAuthorities2());

	}

	@Override
	@Transactional
	public void withdrawAccount(String username) {
		// TODO Auto-generated method stub
		MemberAccount mAccount = mAccountRepository.findOneByEmail(username);
		mAccount.setEnabled(false);

		mAccountRepository.save(mAccount);

	}

}
