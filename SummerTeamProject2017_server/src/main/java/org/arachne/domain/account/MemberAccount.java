package org.arachne.domain.account;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode
public class MemberAccount implements UserDetails {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1375614413821197200L;

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;

	@NotNull
	@Column(name = "member_email", unique = true)
	@Email
	private String email;

	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
	
	@NotNull
	private String password;

	@Pattern(regexp = "^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$")
	private String phoneNum;

	@Column(name="member_name")
	private String name;
	
	
	
	@OneToMany(mappedBy = "authoritiesOwner" ,fetch=FetchType.EAGER)
	@JsonBackReference
	private Set<Role> authorities = new HashSet<>();

	// 계정 만료여부
	@Column
	private boolean isAccountNonExpired;

	// 계정 잠김여부 ex)5회비번틀림 --> lock
	@Column
	private boolean isAccountNonLocked;

	// 패스워드 만료 여부
	@Column
	private boolean isCredentialsNonExpired;

	// 사용가능한 계정인가
	@Column
	private boolean isEnabled;

	
	//constructer-------------------
	public MemberAccount() {
		this.isAccountNonExpired = true;
		this.isAccountNonLocked = true;
		this.isCredentialsNonExpired = true;
		this.isEnabled = true;
	}

	public MemberAccount(String email, String password, String phoneNum,String name) {
		super();
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;
		this.name=name;
		
		
		this.isAccountNonExpired = true;
		this.isAccountNonLocked = true;
		this.isCredentialsNonExpired = true;
		this.isEnabled = true;

	}
	//-----------------
	
	
	
	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Set<Role> getAuthorities2() {
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isEnabled;
	}

}
