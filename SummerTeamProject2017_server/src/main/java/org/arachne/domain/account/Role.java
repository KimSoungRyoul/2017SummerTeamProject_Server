package org.arachne.domain.account;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Role implements GrantedAuthority {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1358200134345703114L;

	@Id
	@GeneratedValue
	@Column(name="authority_id")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date grantedDate;
	
	
	@Enumerated(EnumType.STRING)
	private RoleType authorityName;
	
	
	@ManyToOne
	@JoinColumn(name="member_id")
	@JsonBackReference
	private MemberAccount authoritiesOwner;
	
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authorityName.toString();
	}


}
