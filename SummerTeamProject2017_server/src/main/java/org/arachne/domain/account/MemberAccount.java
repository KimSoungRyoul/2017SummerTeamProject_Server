package org.arachne.domain.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MemberAccount implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1375614413821197200L;

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;

	@NotNull
	@Column(unique = true)
	@Email
	private String email;

	@NotNull
	private String password;

	// @Pattern(regexp = "^01(?:0|1|[6-9]) - (?:\\d{3}|\\d{4}) - \\d{4}$")
	private String phoneNum;

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

	@OneToMany(mappedBy="authAccount")
	private List<Role> authorities = new ArrayList<>();

	public MemberAccount(String email, String password, String phoneNum) {
		super();
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;

		this.isAccountNonExpired = true;
		this.isAccountNonLocked = true;
		this.isCredentialsNonExpired = true;
		this.isEnabled = true;

		
		
	}

	
	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	
	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
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
		return false;
	}

	

	@Override
    public String toString() {
        return ToStringBuilder
            .reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
