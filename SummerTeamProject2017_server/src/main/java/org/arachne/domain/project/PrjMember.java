package org.arachne.domain.project;

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

import org.arachne.domain.account.MemberAccount;

import lombok.Data;

@Entity
@Data
public class PrjMember {

	@Id
	@GeneratedValue
	@Column(name="prj_mem_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="member_id")
	private MemberAccount mAccount;
	
	
		
	
	//@Column(unique=true)
	private String nickName;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date joinDate;
	
	
	
	@Enumerated(EnumType.STRING)
	private TeamPosition position;
	
	
	
	
	
}
